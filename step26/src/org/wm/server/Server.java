package org.wm.server;

import org.wm.dao.EmpDao;
import org.wm.dao.impl.EmpDaoImpl;
import org.wm.thread.EmpThread;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(9999);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("服务器已开启！！！！");
        while (true){
            Socket client = null;
            try {
                client = server.accept();
                new Thread(new EmpThread(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
