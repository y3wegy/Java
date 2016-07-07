package com.jdk.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/20/13
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class GenericMethod {
    public static void main(String[] args) {
        GenericMethod demo = new GenericMethod();
        demo.function("ssss");

        demo.function2(demo.<String, String>map());
    }

    /*
 generaic  use in method
  */
    public <U, V> void function(U u)

    {
        System.out.println(u);
    }

    public void function2(Map<String, String> map) {
        System.out.println("sddf");
    }

    private <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }
}
