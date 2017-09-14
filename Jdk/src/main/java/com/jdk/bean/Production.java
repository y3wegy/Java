package com.jdk.bean;

import java.io.Serializable;

public class Production implements Serializable{
    private static int staticFiled = 1;
    private int id = 1;
    private String subject;
    private Double price;
    private int count;
    private String description;

    public Production() {
    }

    public Production(int id, String subject, Double price, int count, String description) {
        this.id = id;
        this.subject = subject;
        this.price = price;
        this.count = count;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Production [id=" + id + ", subject=" + subject + ", price="
                + price + ", count=" + count + ", description=" + description
                + "]";
    }
}
