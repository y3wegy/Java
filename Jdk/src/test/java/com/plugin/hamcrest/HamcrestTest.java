package com.plugin.hamcrest;

import com.module.SimpleBean;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by Rui on 1/22/14.
 */
public class HamcrestTest {
    @Test
    public void testEqualTo() {
        String var = new String("!");
        String var2 = new String("!");

        assertTrue(var.equals(var2));
        assertThat(var, equalTo(var2));  //call Object.equals(Object)

        assertThat(var, is(equalTo(var2)));
    }

    @Test
    public void testAdd() {
        int s = new SimpleBean().add(1, 1);
        assertThat(s, allOf(greaterThan(1), lessThan(3)));

        assertThat(s, anyOf(greaterThan(1), lessThan(1)));

        assertThat(s, anything());

        assertThat(s, is(2));

        //assertThat(s,2);  //wrong

        assertThat(s, not(1));
    }

    @Test
    public void testDiv() {
        double b = new SimpleBean().div(10, 3);
        assertThat(b, closeTo(3.0, 0.5));

        assertThat(b, greaterThan(3.0));

        assertThat(b, lessThan(3.5));

        assertThat(b, greaterThanOrEqualTo(3.3));

        assertThat(b, lessThanOrEqualTo(3.4));
    }

    @Test
    public void testString() {
        String name = new SimpleBean().getName("ChenRui");
        assertThat(name, containsString("Chen"));

        assertThat(name, startsWith("Ch"));

        assertThat(name, endsWith("i"));

        assertThat(name, equalTo("ChenRui"));

        assertThat(name, equalToIgnoringCase("chenrui"));
        //equalToIgnoringWhiteSpace：字符串变量在忽略头尾任意空格的情况下等于指定字符串时，测试通过
        assertThat(name, equalToIgnoringWhiteSpace("ChenRui  "));
    }

    @Test
    public void testCollection() {
        List<String> itemList = Arrays.asList("123", "234", "345");

        List<String> list = new SimpleBean().getList("123");
        assertThat(list, hasItem("123"));

        assertThat(itemList, hasItems("123", "234"));

        //assertThat(hasItemInArray(itemList));  //A shortcut to the frequently used  hasItemInArray(equalTo(x))

        Map<String, String> map = new SimpleBean().getMap("1", "one");

        Map<String, String> expectMap = new HashMap<String, String>();

        assertThat(map, not(sameInstance(expectMap)));
        expectMap.put("1", "one");

        assertThat(map, sameInstance(map));

        assertThat(map, instanceOf(HashMap.class));

        assertThat(map, notNullValue());

        assertThat(map, not(nullValue()));


        assertThat(map, hasEntry("1", "one"));

        assertThat(map, hasKey("1"));

        assertThat(map, hasValue("one"));


    }

    @Test
    public void testWithJUnitHamcrestNotSameInstance() {
        final int[] integers = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        final int expectedResult = 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15;
        int result = 2 * 3;
        for (int item : integers)
            result *= item;

        assertThat(result, not(sameInstance(expectedResult)));

        assertThat(result,
                describedAs(
                        "Not same object (different identity reference)",
                        sameInstance(expectedResult)));
        /**
         java.lang.AssertionError:
         Expected: Not same object (different identity reference)
         got: <2004310016>
         */
    }

}
