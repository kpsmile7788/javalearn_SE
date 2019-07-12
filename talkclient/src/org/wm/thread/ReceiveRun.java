package org.wm.thread;

import org.wm.util.CloseUtil;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveRun implements Runnable{

    private DataInputStream dis;
    private boolean isStop = false;

    public ReceiveRun(Socket client) {
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            isStop = true;
            CloseUtil.closeAll(dis);
        }
    }

    private String getMessage(){
        String s = "";
        try {
            s = dis.readUTF();
        } catch (IOException e) {
            isStop = true;
            CloseUtil.closeAll(dis);
        }
        return s;
    }

    @Override
    public void run() {
        while (!isStop){
            System.out.println(getMessage());
        }
    }
}
