package com.bjsxt.datastream;

import java.io.*;

public class TestDataStream {
    public static void main(String[] args) throws IOException {

        DataOutputStream dos = new DataOutputStream(new FileOutputStream("E:\\b.txt"));
        dos.writeInt(1222);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.writeDouble(11.1d);
        dos.writeUTF("类好啊");
        dos.close();

        DataInputStream dis = new DataInputStream(new FileInputStream("E:\\b.txt"));
        System.out.println(dis.readInt());
        System.out.println(dis.readBoolean());
        System.out.println(dis.readChar());
        System.out.println(dis.readDouble());
        System.out.println(dis.readUTF());
        dis.close();
    }
}
