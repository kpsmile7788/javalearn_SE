package com.bjsxt.Type1;

public class A4 extends A3{
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public A4() {
    }

    public A4(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A4{" +
                "a='" + a + '\'' +
                '}';
    }
}
