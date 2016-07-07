package com.jdk.clone;

/**
 * Created by a549238 on 8/12/2015.
 */
public class Student implements Cloneable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
