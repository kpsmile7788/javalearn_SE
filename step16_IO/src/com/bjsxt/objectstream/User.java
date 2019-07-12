package com.bjsxt.objectstream;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 4430210559845719515L;
    private String uName;
    private String uPwd;
    private int age;

    public User() {
    }

    public User(String uName, String uPwd) {
        this.uName = uName;
        this.uPwd = uPwd;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                '}';
    }
}
