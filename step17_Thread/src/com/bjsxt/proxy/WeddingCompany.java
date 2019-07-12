package com.bjsxt.proxy;

public class WeddingCompany implements Wedding{

    private Wedding groom;

    public WeddingCompany(Wedding groom) {
        this.groom = groom;
    }

    private void before(){
        System.out.println("布置婚礼现场！！！！！");
    }

    private void after(){
        System.out.println("清理婚礼现场！！！！！");
    }

    @Override
    public void wedding() {
        before();
        groom.wedding();
        after();
    }
}
