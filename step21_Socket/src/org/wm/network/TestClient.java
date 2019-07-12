package org.wm.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost",8888);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("Hello");
        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());
        dis.close();
        dos.close();
        client.close();
    }
}
