package com.bjsxt.Type1;

import java.util.ArrayList;

public class TestType {

    public static void main(String[] args) {

        ArrayList<A1> al1 = new ArrayList<A1>();
        A1 a1 = new A1("a1");
        al1.add(a1);

        ArrayList<A2> al2 = new ArrayList<A2>();
        A2 a2 = new A2("a2");
        al2.add(a2);

        ArrayList<A3> al3 = new ArrayList<A3>();
        A3 a3 = new A3("a3");
        al3.add(a3);

        ArrayList<A4> al4 = new ArrayList<A4>();
        A4 a4 = new A4("a4");
        al4.add(a4);

        ArrayList<A5> al5 = new ArrayList<A5>();
        A5 a5 = new A5("a5");
        al5.add(a5);

        show(al1);
    }

    public static void show(ArrayList<? super A3> a3){
        System.out.println(a3);
    }
}
