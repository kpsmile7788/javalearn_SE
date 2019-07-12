package org.wm.client;

import org.wm.entity.User;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.141.144",9999);
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        User user = getUser();
        oos.writeObject(user);
        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());
        closeAll(dis,oos,client);
    }

    public static void closeAll(Closeable...closeables){
        for (Closeable closeable : closeables) {
            if(closeable != null){
                try {
                    closeable.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static User getUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = input.next();
        System.out.println("请输入密码：");
        String pwd = input.next();

        return new User(name,pwd);
    }

}