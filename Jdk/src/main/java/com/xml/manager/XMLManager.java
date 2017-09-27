package com.xml.manager;

import com.xml.XMLException;
import com.xml.bean.Student;

import java.util.List;

/**
 * Created by Rui on 1/27/2016.
 */
public interface XMLManager {

    String LABEL_STUDENT = "student";
    String ERROR_MSG_BUILD_DOC_FAILED = "Create DocumentBuilder failed";

    public void create(List<Student> students) throws XMLException;

    public List<Student> get() throws XMLException;

    public Student getStudentByName(String name) throws XMLException;

    public void delByName(String name) throws XMLException;
}
