package org.wm.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("localhost",9999);
        SocketChannel channel = null;

        try {
            channel = SocketChannel.open();
            channel.connect(address);
            Scanner reader = new Scanner(System.in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
