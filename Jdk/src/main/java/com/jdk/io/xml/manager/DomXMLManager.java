package com.jdk.io.xml.manager;

import com.jdk.io.xml.XMLException;
import com.jdk.io.xml.bean.Student;
import org.apache.log4j.Logger;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a549238 on 1/27/2016.
 */
public class DomXMLManager implements XMLManager {

    public static final Logger logger = Logger.getLogger(DomXMLManager.class);
    private String filepath;

    public DomXMLManager(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void create(List<Student> students) throws XMLException {
        File file = new File(filepath);
        if (file.exists())      // del  file  if  exists
        {
            file.delete();
        }
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = getDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error(e);
            throw new XMLException(e);
        }
        if (documentBuilder == null) {
            throw new IllegalArgumentException(ERROR_MSG_BUILD_DOC_FAILED);
        }
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        for (Student student : students) {
            Element element = document.createElement(LABEL_STUDENT);
            Element nameElement = document.createElement("name");
            Text nameText = document.createTextNode(student.getName());
            nameElement.appendChild(nameText);
            Element ageElement = document.createElement("age");
            Text ageText = document.createTextNode(String.valueOf(student.getAge()));
            ageElement.appendChild(ageText);
            Element sexElement = document.createElement("sex");
            Text sexText = document.createTextNode(student.getSex());
            sexElement.appendChild(sexText);
            element.appendChild(nameElement);
            element.appendChild(ageElement);
            element.appendChild(sexElement);
            root.appendChild(element);
        }
        saveFile(filepath, document);   // save File
    }

    @Override
    public List<Student> get() throws XMLException {
        List<Student> studentList = null;
        Document document = null;
        try {
            DocumentBuilder documentBuilder = getDocumentBuilder();
            if (documentBuilder == null) {
                throw new IllegalArgumentException("Create DocumentBuilder failed");
            }
            studentList = new ArrayList<>();
            document = documentBuilder.parse(new File(filepath));
            Element element = document.getDocumentElement();
            NodeList nodeList = element.getElementsByTagName("student");
            NodeList nameNode = null;
            NodeList ageNode = null;
            NodeList sexNode = null;
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element studentEle = (Element) nodeList.item(i);
                Student student = new Student();
                nameNode = studentEle.getElementsByTagName("name");
                student.setName(nameNode.item(0).getTextContent()); //nameNode.item(0).getFirstChild().getNodeValue()
                ageNode = studentEle.getElementsByTagName("age");
                student.setAge(Integer.parseInt((ageNode.item(0).getTextContent())));
                sexNode = studentEle.getElementsByTagName("sex");
                student.setSex(sexNode.item(0).getTextContent());
                studentList.add(student);
            }
            return studentList;
        } catch (Exception e) {
            logger.error(e);
            throw new XMLException(e);
        }

    }

    @Override
    public Student getStudentByName(String name) throws XMLException {
        List<Student> allStudents = get();
        for (Student student : allStudents) {
            if (student.getName().equals(name))
                return student;
        }
        return null;
    }

    @Override
    public void delByName(String name) throws XMLException {
        Document document = null;
        try {
            DocumentBuilder documentBuilder = getDocumentBuilder();
            if (documentBuilder == null) {
                throw new IllegalArgumentException("Create DocumentBuilder failed");
            }
            document = documentBuilder.parse(new File(filepath));
            Element root = document.getDocumentElement();
            NodeList nodeList = root.getElementsByTagName("student");
            Element tempElement = null;
            NodeList namenode = null;
            Node node = null;
            for (int i = 0; i < nodeList.getLength(); i++) {
                tempElement = (Element) nodeList.item(i);
                namenode = tempElement.getElementsByTagName("name");
                node = namenode.item(0);
                if (node.getTextContent().equals(name)) {
                    root.removeChild(tempElement);
                }
            }
            saveFile(filepath, document);
        } catch (Exception e) {
            logger.error(e);
            throw new XMLException(e);
        }
    }

    private DocumentBuilder getDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder();
    }


    private void saveFile(String savefilepath, Document document) throws XMLException {
        DOMSource domSource = null;
        StreamResult streamResult = null;
        TransformerFactory transformerFactory;
        Transformer transformer;
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(savefilepath))) {
            domSource = new DOMSource(document);
            streamResult = new StreamResult(outputStreamWriter);
        } catch (IOException e) {
            logger.error(e);
            throw new XMLException(e);
        }
        try {
            transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(domSource, streamResult);
        } catch (TransformerException e) {
            logger.error(e);
            throw new XMLException(e);
        }

    }
}
