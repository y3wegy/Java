package com.jdk.string;

import com.utils.FilePathUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by a549238 on 5/12/2015.
 */
public class StringUtilsdemo {
    @Test
    public void testIsBlank() {
        String value = null;
        System.out.println(StringUtils.isBlank(value));
        System.out.println(StringUtils.isEmpty(value));

        System.out.println("------------------------");
        System.out.println(StringUtils.isBlank(value));
        System.out.println(StringUtils.isEmpty(value));
        System.out.println(StringUtils.join(new String[]{"1", "2"}, "-"));

        FilePathUtils demo = new FilePathUtils();
    }

    @Test
    public void testJoin() {
        List<String> values = new ArrayList<String>();
        values.add("1");
        values.add("2");
        System.out.println(StringUtils.join(Arrays.asList("123,234")));
    }
}
