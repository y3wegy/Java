package com.jdk.xmldemo.manager;

import com.jdk.xmldemo.bean.Student;

import java.util.List;

/**
 * Created by a549238 on 1/27/2016.
 */
public interface XMLManager {

    public void create(List<Student> students) throws Exception;

    public List<Student> get() throws Exception;

    public Student getStudentByName(String name) throws Exception;

    public void delByName(String name) throws Exception;
}
