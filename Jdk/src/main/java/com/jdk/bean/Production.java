package com.jdk.bean;

import org.apache.commons.lang3.ArrayUtils;

import java.io.Serializable;
import java.util.Date;

public class Production implements Serializable {
    private static int staticFiled = 1;
    private int id = 1;
    private String subject;
    private Double price;
    private int count;
    private String description;
    private Production[] component;
    private Date lastUpdateDate;

    public Production() {
    }

    public Production(int id, String subject, Double price, int count, String description, Production[] component, Date lastUpdateDate) {
        this.id = id;
        this.subject = subject;
        this.price = price;
        this.count = count;
        this.description = description;
        this.component = component;
        this.lastUpdateDate = lastUpdateDate;
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

    public Production[] getComponent() {
        return component;
    }

    public void setComponent(Production[] component) {
        this.component = component;
    }


    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(100);
        stringBuilder.append("Production [id=").append(id).append(", subject=").append(subject)
                .append(", price=").append(price).append(", count=").append(count)
                .append(", description=").append(description).append(", component=").append(ArrayUtils.toString(component))
                .append(", lastUpdateDate=").append(lastUpdateDate)
                .append("]");
        return stringBuilder.toString();
    }
}
