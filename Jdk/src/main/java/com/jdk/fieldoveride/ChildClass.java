package com.jdk.fieldoveride;

import org.junit.Test;

public class ChildClass extends FatherClass {
    public String publicField = "Child - public ";
    protected String protectedField = "Child-protected";
    /**
     * friendly *
     */
    String friendlyField = "Child-friendly";
    private String privateField = "Child-private";
    public String res = getPrivateFiledValue() + ";";

    public static void main(String[] args) {
        ChildClass subClazz = new ChildClass();
        System.out.println("SubClass subClazz =new SubClass()");
        System.out.println(subClazz.getPrivateFiledValue());
        System.out.println(subClazz.friendlyField);
        System.out.println(subClazz.protectedField);
        System.out.println(subClazz.publicField);
        System.out.println(subClazz.res);
    }

    @Override
    public String getPrivateFiledValue() {
        System.out.println("Enter Child method");
        return privateField;
    }

    @Test
    public void testValue() {
        ChildClass subClazz = new ChildClass();
        System.out.println("SubClass subClazz =new SubClass()");
        System.out.println(subClazz.getPrivateFiledValue());
        System.out.println(subClazz.friendlyField);
        System.out.println(subClazz.protectedField);
        System.out.println(subClazz.publicField);
        System.out.println(subClazz.res);

    }

    @Test
    public void testFather() {
        FatherClass faher = new FatherClass();
        System.out.println("ParentClass parentClass = new ParentClass()");
        System.out.println(faher.getPrivateFiledValue());
        System.out.println(faher.friendlyField);
        System.out.println(faher.protectedField);
        System.out.println(faher.publicField);

    }

    @Test
    public void testSub() {
        FatherClass subClass = new ChildClass();
        System.out.println("FatherClass subClass = new SubClass()");
        System.out.println(subClass.getPrivateFiledValue());
        System.out.println(subClass.friendlyField);
        System.out.println(subClass.protectedField);
        System.out.println(subClass.publicField);
        System.out.println(subClass.res);
    }

}

class FatherClass {
    public String publicField = "Father-public ";
    protected String protectedFieldd = "Father-protected";
    protected String protectedField = "Father-protected";
    /**
     * friendly *
     */
    String friendlyField = "Father-friendly";
    private String privateFiled = "Father-private";
    public String res = getPrivateFiledValue() + ";";

    public String getPrivateFiledValue() {
        System.out.println("Enter Father method");
        return privateFiled;
    }
}
