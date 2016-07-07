package com.jdk.classpkg.classtype;

import com.jdk.classpkg.classtype.module.SimpleBean;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 2/27/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClassFieldAndMethodParamTypeTest {
    @Test
    public void testFieldType() throws Exception {
        Field[] fields = SimpleBean.class.getFields();
        for (Field field : fields) {
            System.out.println(field.getGenericType().getClass());
        }
    }

    @Test
    public void testMethod() throws Exception {
        ClassFieldAndMethodParamTypeTest demo = new ClassFieldAndMethodParamTypeTest();
        demo.function2(null);
    }

    @Test
    public void testWorkSpace() throws Exception {
        System.out.println("user.home:" + System.getProperty("user.home"));  //user.home:C:\Documents and Settings\a549238
    }


    public void function(int[] a, String b) {

    }

    public void function2(String[] ss) {
        Method[] method1 = ClassFieldAndMethodParamTypeTest.class.getDeclaredMethods();
        for (Method method2 : method1) {
            Type[] types = method2.getGenericParameterTypes();
            Class[] clazz = method2.getParameterTypes();
            System.out.println("method name:" + method2.getName());
            for (Class item : clazz)
                System.out.println("  class->" + item.getSimpleName());
            System.out.println("-------------");

            for (Type item2 : types) {
                if (item2 instanceof GenericArrayType)
                    System.out.println(" GenericArrayType:" + ((GenericArrayType) item2).getGenericComponentType());
                else if (item2 instanceof ParameterizedType)
                    System.out.println(" ParameterizedType:" + ((ParameterizedType) item2).getActualTypeArguments() + " ;  " + ((ParameterizedType) item2).getRawType());
                else
                    System.out.println(item2);
            }

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
        }


    }
}
