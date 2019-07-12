package com.bjsxt.url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class TestURL {
    public static void main(String[] args) throws IOException {

        URL url = new URL("http://www.baidu.com");
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream("E:\\baidu.html");

        byte[] buf = new byte[1024];
        int length = 0;
        while((length = is.read(buf)) != -1){
            os.write(buf,0,length);
        }
        os.close();
        is.close();


    }
}
