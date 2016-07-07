package com.test;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by a549238 on 5/29/2015.
 */
public class Demo {

    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    private static final String[] DATE_LABELS = new String[]{"LAST_UPDATE_DATE","START_TIME","END_TIME"};

    private static boolean isDate(String label) throws Exception
    {
        return ArrayUtils.contains(DATE_LABELS, label);
    }

    public static  void main(String[] args)
    {
        try {
            System.out.println(isDate("AAA"));
            System.out.println(isDate(" "));
            System.out.println(isDate(null));

            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            System.out.println(df.format(new Date()));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void testValue() {
        Bean bean = new Bean();
        change(bean);
        System.out.println(bean.field);
        String str = "222";
        change2(str);
        System.out.println(str);

        Integer i = new Integer(2);
        change3(i);
        System.out.println(i);
    }

    public void change2(String str)

    {
        str = str + "1";
    }

    public void change(final Bean bean) {
        bean.field = bean.field + "1";
    }

    public void change3(Integer i) {
        i = i + 1;
    }

    @Test
    public void testEmpty() {
        List<String> aa = null;
        for (String a : aa)
            System.out.println(a);

    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 29);
        System.out.println("now " + calendar.getTime());
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        assertEquals("a", "a");
        System.out.println("now " + calendar.getTime());

    }

    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("123");
        sb.delete(0, sb.length());
        System.out.println("1212:"+sb.toString());

        StringBuffer sf = new StringBuffer();
        sf.append("12");
    }

    @Test
    public void testDateFormat() throws Exception {
        SimpleDateFormat fm = new SimpleDateFormat("'.Y'yyyy'.D'MMdd'.'kkmmss'.'");
        String mArchDate = fm.format(Calendar.getInstance().getTime());
        System.out.println(mArchDate);
    }

    class Bean {
        public String field = "1";
    }
}
