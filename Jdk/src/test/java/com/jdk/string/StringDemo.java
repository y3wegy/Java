package com.jdk.string;

/**
 * Created by a549238 on 1/24/14.
 */
public class StringDemo {

    public static void main(String[] args) {
        StringDemo demo = new StringDemo();
        String var = "狂拽帅气就是我";
        System.out.println(demo.StrToBinstr(var));
    }

    private String StrToBinstr(String str) {
        char[] strChar = str.toCharArray();
        String result = "";
        for (int i = 0; i < strChar.length; i++) {
            result += Integer.toBinaryString(strChar[i]) + " ";
        }
        return result;
    }

}

