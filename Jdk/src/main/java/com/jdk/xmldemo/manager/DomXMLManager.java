package com.jdk.xmldemo.manager;

import com.jdk.xmldemo.bean.Student;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a549238 on 1/27/2016.
 */
public class DomXMLManager implements XMLManager {

    private String filepath;

    public DomXMLManager(String filepath) {
        this.filepath = filepath;
    }

    @Override
    public void create(List<Student> students) throws Exception {
        File file = new File(filepath);
        if (file.exists())      // del  file  if  exists
        {
            file.delete();
        }
        DocumentBuilder documentBuilder = getDocumentBuilder();
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("root");
        document.appendChild(root);
        for (Student student : students) {
            Element element = document.createElement("student");
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
    public List<Student> get() throws Exception {
        DocumentBuilder documentBuilder = getDocumentBuilder();
        List<Student> studentList = new ArrayList<Student>();
        Document document = documentBuilder.parse(new File(filepath));
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getElementsByTagName("student");
        NodeList nameNode = null, ageNode = null, sexNode = null;
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
    }

    @Override
    public Student getStudentByName(String name) throws Exception {
        List<Student> allStudents = get();
        for (Student student : allStudents) {
            if (student.getName().equals(name))
                return student;
        }
        return null;
    }

    @Override
    public void delByName(String name) throws Exception {
        DocumentBuilder documentBuilder = getDocumentBuilder();
        Document document = documentBuilder.parse(new File(filepath));
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
    }

    private DocumentBuilder getDocumentBuilder() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return documentBuilder;
    }


    private void saveFile(String savefilepath, Document document) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(savefilepath);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(outputStreamWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.transform(domSource, streamResult);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

}
