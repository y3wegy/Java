package com.jdk.value;

import org.junit.Test;


/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 3/21/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinTest {

    private static String getBinaryArray(String str) {
        char[] charArray = str.toCharArray();
        String strBinary = "";
        for (int i = 0; i < charArray.length; i++) {
            strBinary += Integer.toBinaryString(charArray[i]) + " ";
        }
        return strBinary;
    }

    @Test
    public void testIntBin() throws Exception {
        String s = Integer.toBinaryString(32);
        System.out.println(s);
        System.out.println(Integer.toBinaryString(12334));
    }

    @Test
    public void testStrtoBinary() {
        final String myWord = "My Name is Chen,Rui";
        System.out.println(getBinaryArray(myWord));
    }

}
