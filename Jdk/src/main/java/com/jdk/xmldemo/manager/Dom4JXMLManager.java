package com.jdk.xmldemo.manager;

import com.jdk.xmldemo.bean.Student;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by a549238 on 1/27/2016.
 */
public class Dom4JXMLManager implements XMLManager {

    private String filepath;

    public Dom4JXMLManager(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void create(List<Student> students) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element root = DocumentHelper.createElement("root");
        document.setRootElement(root);         //
        Element element = null;
        for (Student student : students) {
            element = root.addElement("student");
            element.addElement("name").addText(student.getName());
            element.addElement("sex").addText(student.getSex());
            element.addElement("age").addText(String.valueOf(student.getAge()));
        }
        root.appendContent(element);  //test diff of  addElement and appendContent
        saveFile(document, filepath);
    }

    @Override
    public List<Student> get() throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(filepath));
        Element root = document.getRootElement();
        Iterator<Element> elementIterator = root.elementIterator("student");
        Element element = null, tempelement2 = null;
        while (elementIterator.hasNext()) {
            Student student = new Student();
            element = elementIterator.next();
            for (Iterator<Element> tempelement = element.elementIterator(); tempelement.hasNext(); ) {
                tempelement2 = tempelement.next();
                if (tempelement2.getName().equals("name"))
                    student.setName(tempelement2.getText());
                else if (tempelement2.getName().equals("sex"))
                    student.setSex(tempelement2.getText());
                else if (tempelement2.getName().equals("age"))
                    student.setAge(Integer.parseInt(tempelement2.getText()));
                studentList.add(student);
            }
        }
        return studentList;
    }

    @Override
    public Student getStudentByName(String name) throws Exception {
        List<Student> studentList = get();
        for (Student student : studentList) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void delByName(String name) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(filepath));
        Element root = document.getRootElement();
        Iterator<Element> elementIterator = root.elementIterator("student");
        Element element = null, tempelement2 = null;
        while (elementIterator.hasNext()) {
            Student student = new Student();
            element = elementIterator.next();
            for (Iterator<Element> tempelement = element.elementIterator(); tempelement.hasNext(); ) {
                tempelement2 = tempelement.next();
                if (tempelement2.getName().equals("name"))
                    if (tempelement2.getText().equals(name))
                        tempelement.remove();
            }
        }
        saveFile(document, filepath);
    }

    private void saveFile(Document document, String savefilepath) throws IOException {
        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(new File(savefilepath)), new OutputFormat("   ", true, "UTF-8"));
        xmlWriter.write(document);
        // xmlWriter.flush();
        xmlWriter.close();
    }
}
