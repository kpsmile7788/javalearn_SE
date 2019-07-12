package com.bjsxt.objectstream;

import java.io.*;

public class TestObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*User user = new User("www","aaa");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("E:\\c.txt"));
        oos.writeObject(user);

        oos.close();*/

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("E:\\c.txt"));
        User user = (User)ois.readObject();
        System.out.println(user);
        ois.close();


    }
}
