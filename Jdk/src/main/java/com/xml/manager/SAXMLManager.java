package com.xml.manager;

import com.xml.XMLException;
import com.xml.bean.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by a549238 on 1/27/2016.
 */
public class SAXMLManager implements XMLManager {
    public static final Logger logger = LoggerFactory.getLogger(SAXMLManager.class);
    private static final String MSG_NO_IMPL = "no implements";
    private String filapath;

    public SAXMLManager(String filepath) {
        this.filapath = filepath;
    }

    @Override
    public void create(List<Student> students) throws XMLException {
        logger.info(filapath);
        throw new XMLException("SAX is for parse file ,not write anything");
    }

    @Override
    public List<Student> get() throws XMLException {
        throw new XMLException(MSG_NO_IMPL);
    }

    @Override
    public Student getStudentByName(String name) throws XMLException {
        throw new XMLException(MSG_NO_IMPL);
    }

    @Override
    public void delByName(String name) throws XMLException {
        throw new XMLException(MSG_NO_IMPL);
    }
}
