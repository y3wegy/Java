package com.jdk.dynamic;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/11/13
 * Time: 11:01 AM
 * To change this template use File | Settings | File Templates.
 */
public class SubClass extends Super {
    public int field = setValue(2);

    public static void print1() {
        System.out.println("run in SubClass.print1()");
    }

    public static void main(String[] args) {
        Super supe = new SubClass();
        System.out.println("upcast  :    field=" + supe.field + " getField()=" + supe.getField());
        supe.print2();
        Super.print1(); //out:run in Super.print1()
        // indecate that static method is belong to class not instance

        SubClass subClass = new SubClass();
        System.out.println("subclass  :  field=" + subClass.field + "       getField()= " + subClass.getField() + "    getSuperField()=" + subClass.getSuperField());
        subClass.print2();
        SubClass.print1();

    }

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }

    @Override
    public void print2() {
        System.out.println("run in SubClass.print2()");
    }
}

class Super {
    public int field = setValue(3);

    public static void print1() {
        System.out.println("run in Super.print1()");
    }

    public int getField() {
        return field;
    }

    public void print2() {
        System.out.println("run in Super.print2()");
    }

    protected int setValue(int value) {
        System.out.println("set Value:" + value);
        return value;
    }
}
