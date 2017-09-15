package com.xml;

import com.xml.bean.Student;
import com.xml.manager.Dom4JXMLManager;
import com.xml.manager.DomXMLManager;
import com.xml.manager.SAXMLManager;
import com.xml.manager.XMLManager;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/14/13
 * Time: 9:47 AM
 * To change this template use File | Settings | File Templates.
 */
public class XmlTest {
    private static final String filepath = XmlTest.class.getClassLoader().getResource("").getPath() + "ss.xml";
    private static final String filepath2 = XmlTest.class.getClassLoader().getResource("").getPath() + "ss2.xml";

    private List<Student> studentList = new ArrayList<Student>();

    @Before
    public void prepareData() {
        Student student1 = new Student();
        student1.setName("y3wegy1");
        student1.setSex("male");
        student1.setAge(23);
        studentList.add(student1);
        Student student2 = new Student();
        student2.setName("y3wegy2");
        student2.setSex("male");
        student2.setAge(24);
        studentList.add(student2);
    }

    @Test
    public void testDOM() throws Exception {
        XMLManager xmlDomManager = new DomXMLManager(filepath);
        xmlDomManager.create(studentList);

        xmlDomManager.getStudentByName("y3wegy1");
        xmlDomManager.delByName("y3wegy2");
    }

    @Test
    public void testDOM4J() throws Exception {
        XMLManager xmlDom4JManager = new Dom4JXMLManager(filepath2);
        xmlDom4JManager.create(studentList);

        xmlDom4JManager.getStudentByName("y3wegy2");
        xmlDom4JManager.delByName("y3wegy2");
    }

    @Test
    public void testSAX() throws Exception {
        XMLManager xmlSAXManalger = new SAXMLManager(filepath);
        XMLManager dom4jManager = new Dom4JXMLManager(filepath);
        dom4jManager.create(studentList);
        xmlSAXManalger.get();

    }
}
