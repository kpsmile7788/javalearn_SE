package com.bjsxt.work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestWork {

    public static void main(String[] args) {

        HashMap<String,Book> hm = new HashMap<String, Book>();

        Book b1 = new Book("Java","Sun",23,Publish.人民邮电出版社);
        Book b2 = new Book("Python","python",13,Publish.机械工业出版社);
        Book b3 = new Book("C++","C++",33,Publish.清华大学出版社);
        Book b4 = new Book("Java","Sun",13,Publish.人民邮电出版社);

        hm.put(b1.getbName(),b1);
        hm.put(b2.getbName(),b2);
        hm.put(b3.getbName(),b3);
        hm.put(b4.getbName(),b4);

        for(Map.Entry<String,Book> element : hm.entrySet()){
            System.out.println(element.getKey()+"------>"+element.getValue());
        }

        System.out.println("-------------------------------------------------------- ");
        TreeMap<String,Book> tm = new TreeMap<String, Book>();

        Book b5 = new Book("Java","Sun",33,Publish.人民邮电出版社);
        Book b6 = new Book("Python","python",43,Publish.机械工业出版社);
        Book b7 = new Book("C++","C++",53,Publish.清华大学出版社);
        Book b8 = new Book("Java","Sun",13,Publish.人民邮电出版社);

        tm.put(b5.getbAuthor(),b5);
        tm.put(b6.getbAuthor(),b6);
        tm.put(b7.getbAuthor(),b7);
        tm.put(b8.getbAuthor(),b8);

        Set<String> keys = tm.keySet();
        for(String key : keys){
            System.out.println(key+"------>"+tm.get(key));
        }

    }
}
