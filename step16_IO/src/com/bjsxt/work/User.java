package com.bjsxt.work;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -5120994120359391405L;
    private String uName;
    private String uPwd;

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
