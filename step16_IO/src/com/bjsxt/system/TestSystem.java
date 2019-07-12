package com.bjsxt.system;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class TestSystem {
    public static void main(String[] args) throws IOException {

        InputStream is = System.in;
        System.out.println(is.read());
        is.close();

        OutputStream os = System.out;
        os.write("aaaaa".getBytes());

        PrintStream ps = System.out;
        ps.println("helloworld");

        os.close();
        ps.close();
    }
}
