package com.bjsxt.Type1;

public class A5 extends A4{
    private String a;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public A5(String a) {
        this.a = a;
    }

    public A5() {
    }

    @Override
    public String toString() {
        return "A5{" +
                "a='" + a + '\'' +
                '}';
    }
}
