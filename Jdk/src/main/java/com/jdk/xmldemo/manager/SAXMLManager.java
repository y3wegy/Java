package com.jdk.xmldemo.manager;

import com.jdk.xmldemo.bean.Student;

import java.util.List;

/**
 * Created by a549238 on 1/27/2016.
 */
public class SAXMLManager implements XMLManager {

    private String filapath;

    public SAXMLManager(String filepath) {
        this.filapath = filepath;
    }

    @Override
    public void create(List<Student> students) throws Exception {

    }

    @Override
    public List<Student> get() throws Exception {
        return null;
    }

    @Override
    public Student getStudentByName(String name) throws Exception {
        return null;
    }

    @Override
    public void delByName(String name) throws Exception {

    }
}
