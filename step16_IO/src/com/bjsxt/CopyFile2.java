package com.bjsxt;

import java.io.*;

public class CopyFile2 {
    /**
     * 使用BufferedInputStream，BufferedOutputStream复制文件
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\Administrator\\Desktop\\jdk api 1.8_google.CHM"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\software\\jdk api 1.8_google.CHM"));

        byte[] buf = new byte[1024];
        int length = 0;
        long startTime = System.currentTimeMillis();
        while((length = bis.read(buf)) != -1){
            bos.write(buf,0,length);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("复制耗时"+(endTime-startTime)+"毫秒");
        bos.close();
        bis.close();
    }
}
