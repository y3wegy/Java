package com.jdk.generic;

import com.jdk.generic.ArrayOfGeneric;
import org.junit.Test;

/**
 * Created by e631876 on 9/12/2017.
 */
public class ArrayOfGenericTest {
    @Test
    public void testArray() throws Exception {
        ArrayOfGeneric<String> array = new ArrayOfGeneric<String>(String.class, 4);
        String[] resp = array.rep();

        System.out.println(resp.toString());
    }
}