package com.xml.manager;

import com.xml.XMLException;
import com.xml.bean.Student;
import org.apache.log4j.Logger;
import java.util.List;

/**
 * Created by Rui on 1/27/2016.
 */
public class SAXMLManager implements XMLManager {
    private static final Logger logger = Logger.getLogger(SAXMLManager.class);
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
