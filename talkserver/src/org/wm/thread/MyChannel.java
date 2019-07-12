package org.wm.thread;

import org.wm.server.Server;
import org.wm.util.CloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * 该类是服务器端的管道的实现类
 *      每个管道内各有一个DataInputStream和DataOutputStream,<这两个流都是属于服务器--------记好>
 * 他们分别连接的是客户端的DataOutputStream和DataInputStream
 */
public class MyChannel implements Runnable {

    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean isStop = false;

    public MyChannel(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            isStop = true;
            CloseUtil.closeAll(dos,dis,client);
        }
    }

    private String reciveMsg(){

        String s = "";
        try {
            s = dis.readUTF();
            System.out.println(s);
        } catch (IOException e) {
            isStop = true;
            CloseUtil.closeAll(dis,dos);
            Server.userList.remove(this);
        }

        return s;
    }

    private void sendMsg(String s){
        if (s != null && !"".equals(s)){
            try {
                dos.writeUTF(s);
                dos.flush();
            } catch (IOException e) {
                isStop = true;
                CloseUtil.closeAll(dis,dos);
            }
        }
    }


    /**
     *      <服务器端只需接收到某一个客户端的消息后把这条消息发送给其他客户端>
     */
    private void sendOther(){
        String s = this.reciveMsg();
        List<MyChannel> userList = Server.userList;
        for (MyChannel channel : userList) {
            if (this == channel)
                continue;
            channel.sendMsg(s);
        }
    }

    @Override
    public void run() {
        while (!isStop)
            sendOther();
    }
}
