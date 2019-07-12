package com.bjsxt.proxy;

public class TestProxy {
    public static void main(String[] args) {
        Groom groom = new Groom();
        WeddingCompany weddingCompany = new WeddingCompany(groom);

        weddingCompany.wedding();
    }
}
