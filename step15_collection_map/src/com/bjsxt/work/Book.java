package com.bjsxt.work;

public class Book {

    private String bName;
    private String bAuthor;
    private double bPrice;
    private Publish bPublish;

    public Book() {
    }

    public Book(String bName, String bAuthor, double bPrice, Publish bPublish) {
        this.bName = bName;
        this.bAuthor = bAuthor;
        this.bPrice = bPrice;
        this.bPublish = bPublish;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public double getbPrice() {
        return bPrice;
    }

    public void setbPrice(double bPrice) {
        this.bPrice = bPrice;
    }

    public Publish getbPublish() {
        return bPublish;
    }

    public void setbPublish(Publish bPublish) {
        this.bPublish = bPublish;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bName='" + bName + '\'' +
                ", bAuthor='" + bAuthor + '\'' +
                ", bPrice=" + bPrice +
                ", bPublish=" + bPublish +
                '}';
    }
}

enum Publish{
    机械工业出版社,人民邮电出版社,清华大学出版社
}
