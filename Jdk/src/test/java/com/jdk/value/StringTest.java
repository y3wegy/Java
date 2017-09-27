package com.jdk.value;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Rui
 * Date: 12/4/13
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringTest {


    @Test
    public void testSub() {
        String str = "IXDE    MXNE                   020130508        00000000                    000000000000000                                                             00000000000000000000000+000030636000000     11000000GICR ISCU HARD CODE COMMENTS                                                                                                                      \n";
        System.out.println(str.substring(176, 176 + 15));
        System.out.println("+:" + str.indexOf("+"));
        System.out.println("-:" + str.indexOf("-"));
        System.out.println("Decimal:" + new BigDecimal("2.301"));
        StringBuilder sb = new StringBuilder("123");
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
        String str2 = "123,234,345,456";
        System.out.println(str2.substring(str2.indexOf(","), str2.lastIndexOf(",")));
        System.out.println(str2.substring(0, str2.lastIndexOf(",")));
    }
}
