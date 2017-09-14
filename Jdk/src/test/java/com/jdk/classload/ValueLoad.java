package com.jdk.classload;

import org.apache.log4j.Logger;
import org.junit.Test;

public class ValueLoad {
    public static final Logger logger =Logger.getLogger(ValueLoad.class);
    @Test
    public void testValue() {
        //Class<Clazz1> clazz1 =Clazz1.class;
        logger.info("get Clazz.class");
        logger.info("Clazz1.valueFinal:" + Clazz1.valueFinal);   //  Clazz1.valueFinal is complie constant, not need to init class
        logger.info("get  Clazz1.valueFinal,to see Clazz1 init whether or not? ");
        logger.info("Clazz1.valueFina2:" + Clazz1.valueFinal2);
        logger.info("Clazz2.valueNoFinal:" + Clazz2.valueNoFinal);
        // Class clazz3 =Class.forName("com.demo.classinit.load.Clazz3");  //actual  call Class.forName(classNmae,true,classload)
        logger.info("get Clazz3 ref");
        logger.info("Clazz3.valueNoFinal:" + Clazz3.valueNoFinal);

        logger.info("Clazz4.value2:" + Clazz4.value2);
    }
}

class Clazz1 {
    public static final int valueFinal = 1;
    public static int valueFinal2 = 5;

    static {
        System.out.println("init Clazz1 completed");
    }
}

class Clazz2 {
    public static int valueNoFinal = 2;

    static {
        System.out.println("init Clazz2 completed");
    }
}

class Clazz3 {
    public static int valueNoFinal = 3;

    static {
        System.out.println("init Clazz3 completed");
    }
}

class Clazz4 {
    public static int value = got(4);
    public static final int value2 = value + 1;

    static {
        System.out.println("init class4 completed!");
    }

    public Clazz4() {
        System.out.println("valueFinal:" + value);
    }

    private static int got(int x) {
        System.out.println("return " + x);
        return x;
    }

}
