package com.jdk.classpkg.classtype;

import com.jdk.classpkg.classtype.module.SimpleBean;
import org.junit.Test;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/28/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class CollectionParamClassTypeTest {

    private final List<SimpleBean> simpleBeanList = new ArrayList<SimpleBean>();
    private final List<List<SimpleBean>> listList = new ArrayList<List<SimpleBean>>();

    {

        try {
            SimpleBean obj = SimpleBean.class.newInstance();
            obj.setName("chenrui");
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    public static Class<?> getClass(Type t) {
        Type genericType = null;
        if (t instanceof ParameterizedType) {
            genericType = ((ParameterizedType) t).getActualTypeArguments()[0];
        } else if (t instanceof GenericArrayType) {
            genericType = ((GenericArrayType) t).getGenericComponentType();
        } else if (t instanceof Class<?>) {
            if (((Class<?>) t).isArray()) {
                genericType = ((Class<?>) t).getComponentType();
            }
        }

        if (genericType instanceof Class<?> && genericType != null) {
            Class<?> clz = (Class<?>) genericType;
            if (meetCondition(clz)) {
                return clz;
            }
        }

        return null;
    }

    public static boolean meetCondition(Class<?> clz) {
        return isBaseTypeClass(clz) || !isJavaClass(clz);
    }

    public static boolean isBaseTypeClass(Class<?> clazz) {
        if (clazz == int.class || clazz == double.class || clazz == long.class || clazz == float.class || clazz == Integer.class
                || clazz == Double.class || clazz == Long.class || clazz == Float.class || clazz == String.class
                || clazz == Date.class || clazz == Boolean.class || clazz == boolean.class || clazz == Character.class
                || clazz == char.class || clazz == Byte.class || clazz == byte.class || clazz == Short.class
                || clazz == short.class || clazz == java.math.BigDecimal.class)
            return true;
        else
            return false;
    }

    public static boolean isJavaClass(Class<?> clz) {
        if (null == clz) {
            return true;
        } else {
            return clz.getClassLoader() == null;
        }
    }

    @Test
    public void testAll() {

        Class<?> listClass = simpleBeanList.getClass();
        System.out.println("simpleBeanList. componentType:" + getClass(listClass));

        System.out.println("listList. componentType:" + getClass(listClass.getComponentType()));
        System.out.println("Class:" + listClass);
        if (Collection.class.isAssignableFrom(simpleBeanList.getClass()))
            System.out.println("asdad");
        System.out.println("getTypeParameters:" + listClass.getTypeParameters());
        System.out.println("getComponentType:" + listClass.getComponentType());

        System.out.println("getGenericSuperclass:" + listClass.getGenericSuperclass());


    }

    @Test
    public void testSuperClass() throws Exception {
        Class<?> listClass = simpleBeanList.getClass();
        Type[] types = listClass.getGenericInterfaces();
        System.out.println("getGenericInterfaces begin!");
        for (Type type : types)
            System.out.println(type);
        System.out.println("getGenericInterfaces end!");
    }

    @Test
    public void testInterface() throws Exception {
        Class<?> listClass = simpleBeanList.getClass();
        Class[] clazzs = listClass.getInterfaces();
        System.out.println("getInterfaces begain!");
        for (Class item : clazzs)
            System.out.println(item);
        System.out.println("getInterfaces end!");

    }
}
