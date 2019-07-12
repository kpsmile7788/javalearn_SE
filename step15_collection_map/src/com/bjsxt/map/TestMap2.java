package com.bjsxt.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class TestMap2 {
    public static void main(String[] args) {
        HashMap<Person,String> hm = new HashMap<Person, String>();

        Person p1 = new Person("lili",22,Gender.女);
        Person p2 = new Person("lili",25,Gender.女);
        Person p3 = new Person("yc",21,Gender.女);
        Person p4 = new Person("wzh",24,Gender.女);

        hm.put(p1,p1.getName());
        hm.put(p2,p2.getName());
        hm.put(p3,p3.getName());
        hm.put(p4,p4.getName());

        HashSet<Person> hs = new HashSet<Person>();

        Set<Person> personSet = hm.keySet();

        for (Person p : personSet) {
            hs.add(p);
        }

        System.out.println(hs);

        HashMap<String,Person> hm1 = new HashMap<String, Person>();

        for(Person p : hs){
            hm1.put(p.getName(),p);
        }

        System.out.println(hm1);
    }
}
