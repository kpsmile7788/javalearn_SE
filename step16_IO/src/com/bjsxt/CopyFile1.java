package com.bjsxt;

import java.io.*;

public class CopyFile1 {
    public static void main(String[] args) throws IOException {

        InputStream is =new FileInputStream("C:\\Users\\Administrator\\Desktop\\jdk api 1.8_google.CHM");
        OutputStream os = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\software\\jdk api 1.8_google.CHM");

        byte[] buf = new byte[1024];
        int length = 0;
        long startTime = System.currentTimeMillis();
        while((length = is.read(buf)) != -1){
            os.write(buf,0,length);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("复制耗时"+(endTime-startTime)+"毫秒");

        os.close();
        is.close();
    }
}
