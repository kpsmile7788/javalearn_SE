package com.bjsxt.iputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TestInputStream {
    public static void main(String[] args) throws IOException {

        InputStream is = new FileInputStream("C:\\Users\\Administrator\\Desktop\\a.txt");

        /*System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());
        System.out.println((char) is.read());*/

        byte[] buf = new byte[1024];
        int length = 0;
        while((length = is.read(buf)) != -1){
            System.out.println(new String(buf,0,length));
        }

        is.close();
    }
}
