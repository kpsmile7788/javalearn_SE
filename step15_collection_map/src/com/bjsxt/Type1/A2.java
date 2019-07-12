package com.bjsxt.Type1;

public class A2 extends A1{
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public A2() {
    }

    public A2(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "A2{" +
                "a='" + a + '\'' +
                '}';
    }
}
