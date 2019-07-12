package org.wm.entity;

public class Black implements Human {
    @Override
    public void laugh() {
        System.out.println("黑-------------笑");
    }

    @Override
    public void cry() {
        System.out.println("黑-------------哭");
    }

    @Override
    public void talk() {
        System.out.println("黑-------------说");
    }
}
