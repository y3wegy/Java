package com.jdk.xml.manager;

import com.jdk.xml.XMLException;
import com.jdk.xml.bean.Student;

import java.util.List;

/**
 * Created by a549238 on 1/27/2016.
 */
public interface XMLManager {

    String LABEL_STUDENT = "student";
    String ERROR_MSG_BUILD_DOC_FAILED = "Create DocumentBuilder failed";

    public void create(List<Student> students) throws XMLException;

    public List<Student> get() throws XMLException;

    public Student getStudentByName(String name) throws XMLException;

    public void delByName(String name) throws XMLException;
}