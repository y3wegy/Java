package com.jdk.generic.cast;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/23/13
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class GenericCast {

    public static void main(String[] args) {
        GenericCast cast = new GenericCast();
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("Object.txt"));
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        if (objectInputStream != null) try {
            List<Widget> list = ArrayList.class.cast(objectInputStream.readObject());
            for (Widget item : list)
                System.out.println(item);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}

class Widget {
}
