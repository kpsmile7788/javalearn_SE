package com.bjsxt.outputstream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestOutputStream {
    public static void main(String[] args) throws IOException {

        OutputStream os = new FileOutputStream("E:\\a.txt");

        os.write(123);
        os.write("dawqewqdsa".getBytes());


        os.close();
    }
}
