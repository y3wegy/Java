package com.jdk.clone;

import org.junit.Test;
/**
 * Created by Rui on 8/12/2015.
 */
public class CloneTest {
    @Test
    public void testObjecttypeClone() {
        Student student = new Student();
        student.setName("AAA");
        Student student1 = student;

        System.out.println(student + ";" + student1);

        try {
            student1 = (Student) student.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        student1.setName("BBB");
        System.out.println(student + ";" + student1);
        System.out.println(student.getName() + "<>" + student1.getName());
    }
}

class Student implements Cloneable {

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


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Student2 {
}

