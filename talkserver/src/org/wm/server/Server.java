package org.wm.server;

import org.wm.thread.MyChannel;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 每个客户端连上服务端后会在服务端建立一个自定义的管道（MyChannel）<该管道负责拉取和发送消息>
 * 服务端拥有一个储存所有管道的容器。（如userList）
 * 每建立一个新的连接后都会把该链接所产生的管道线程扔入userList中
 */
public class Server {

    public static List<MyChannel> userList = new ArrayList<MyChannel>();

    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(9999);
        System.out.println("------------------Server is Open-----------------");

        while (true) {
            Socket client = server.accept();
            MyChannel myChannel = new MyChannel(client);
            new Thread(myChannel).start();
            userList.add(myChannel);
        }
    }
}
