package com.jdk.nio.serializableDemo;

import java.io.*;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/9/13
 * Time: 1:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class Worm implements Serializable {

    private static final String FILE_NAME = "Object.txt";
    private static Random rand = new Random(47);
    private Data[] datas = {
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10)),
            new Data(rand.nextInt(10))
    };

    private Worm next;
    private char c;

    public Worm(int i, char x) {
        c = x;
        if (--i > 0)
            next = new Worm(i, (char) (x + 1));
    }

    public Worm() {
        System.out.println("Default Constructor");
    }

    public static void main(String[] args) {
        Worm worm = new Worm(6, 'a');
        System.out.println("worm:" + worm);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            objectOutputStream.writeObject("Worm Storage\n");
            objectOutputStream.writeObject(worm);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME));
            String s = (String) objectInputStream.readObject();
            Worm serializabledWorm = (Worm) objectInputStream.readObject();
            System.out.println(s + serializabledWorm);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream1.writeObject("Worm Storage\n");
            objectOutputStream1.writeObject(worm);
            objectOutputStream1.flush();
            ObjectInputStream objectInputStream1 = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            s = (String) objectInputStream1.readObject();
            Worm worm2 = (Worm) objectInputStream1.readObject();
            System.out.println(s + worm2);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(":");
        stringBuilder.append(c).append("(");
        for (Data data : datas)
            stringBuilder.append(data);
        stringBuilder.append(")");
        if (next != null)
            stringBuilder.append(next);
        return stringBuilder.toString();
    }
}

class Data implements Serializable {
    private int n;

    public Data(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return Integer.toString(n);
    }
}
