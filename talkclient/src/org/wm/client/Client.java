package org.wm.client;

import org.wm.thread.ReceiveRun;
import org.wm.thread.SendRun;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;


public class Client {

    private static File file = new File("Client.properties");
    private static Properties properties = new Properties();

    private static String HOSTNAME = "";
    private static int PORT = 0;
    static {
        if (!file.exists()){
            try {
                file.createNewFile();
                FileOutputStream fos = new FileOutputStream(file);

                properties.setProperty("hostname","localhost");
                properties.setProperty("port","9999");

                properties.store(fos,null);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            properties.load(new FileInputStream(file));
            HOSTNAME = properties.getProperty("hostname");
            PORT = Integer.parseInt(properties.getProperty("port"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception{

        Socket client = new Socket(HOSTNAME,PORT);
        Scanner input = new Scanner(System.in);
        System.out.println("客户端已启动，请输入您的昵称：");
        String name = input.next();
        System.out.println("已进入聊天室！");
        new Thread(new SendRun(client),name).start();
        new Thread(new ReceiveRun(client),name).start();

    }
}
