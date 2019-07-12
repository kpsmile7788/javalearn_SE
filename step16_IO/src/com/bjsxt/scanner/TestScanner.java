package com.bjsxt.scanner;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new File("E:\\a.txt"));

        while(in.hasNext()){
            System.out.println(in.next());
        }

        in.close();

    }
}
