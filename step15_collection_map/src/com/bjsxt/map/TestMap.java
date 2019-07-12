package com.bjsxt.map;

import java.util.HashMap;

public class TestMap {
    public static void main(String[] args) {

        HashMap<String,Person> hm = new HashMap<String, Person>();

        Person p1 = new Person("lili",22,Gender.女);
        Person p2 = new Person("lili",25,Gender.女);
        Person p3 = new Person("yc",21,Gender.女);
        Person p4 = new Person("wzh",24,Gender.女);

        /*Person  p1=new Person("marry",20,Gender.女);
        Person  p2=new Person("lili",20,Gender.女);
        Person  p3=new Person("jack",20,Gender.女);
        Person  p4=new Person("marry",23,Gender.男);*/
        //添加元素

        hm.put(p1.getName(),p1);
        hm.put(p2.getName(),p2);
        hm.put(p3.getName(),p3);
        hm.put(p4.getName(),p4);

        System.out.println(hm.size());
        System.out.println(hm);

        System.out.println(hm.containsKey(p1));
    }
}
