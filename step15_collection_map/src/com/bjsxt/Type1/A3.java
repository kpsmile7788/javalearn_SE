package com.bjsxt.Type1;

public class A3 extends A2{
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public A3(String a) {
        this.a = a;
    }

    public A3() {
    }

    @Override
    public String toString() {
        return "A3{" +
                "a='" + a + '\'' +
                '}';
    }
}
