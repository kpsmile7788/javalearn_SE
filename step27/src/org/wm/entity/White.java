package org.wm.entity;

public class White implements Human {
    @Override
    public void laugh() {
        System.out.println("白-------------笑");
    }

    @Override
    public void cry() {
        System.out.println("白-------------哭");
    }

    @Override
    public void talk() {
        System.out.println("白-------------说");
    }
}
