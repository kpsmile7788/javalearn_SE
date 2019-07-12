package org.wm.entity;

public class Yellow implements Human{
    @Override
    public void laugh() {
        System.out.println("黄-------------笑");
    }

    @Override
    public void cry() {
        System.out.println("黄-------------哭");
    }

    @Override
    public void talk() {
        System.out.println("黄-------------说");
    }
}
