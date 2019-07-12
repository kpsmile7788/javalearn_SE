package com.bjsxt.arraylist;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
        List<String> al = Arrays.asList("java","world","hadoop","hello");

        Iterator<String> itr = al.iterator();

       /* while(itr.hasNext()){
            String s
        }*/
       System.out.println(al);
    }
}
