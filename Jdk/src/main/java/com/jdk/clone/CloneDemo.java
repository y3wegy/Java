package com.jdk.clone;

import org.junit.Test;

/**
 * Created by a549238 on 8/12/2015.
 */
public class CloneDemo {
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
