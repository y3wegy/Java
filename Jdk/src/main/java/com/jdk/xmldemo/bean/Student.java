package com.jdk.xmldemo.bean;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/14/13
 * <p/>
 * Time: 9:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class Student {
    private String name;
    private String sex;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
