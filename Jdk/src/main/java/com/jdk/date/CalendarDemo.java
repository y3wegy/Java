package com.jdk.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by a549238 on 10/9/2015.
 */
public class CalendarDemo {

    @Test
    public void testTimeZone() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Local time zone:" + calendar.getTimeZone());

        System.out.println(Arrays.toString(TimeZone.getAvailableIDs()));
        calendar.setTimeZone(TimeZone.getTimeZone("Pacific/Niue"));
        System.out.println("GTM+1 :" + calendar.get(Calendar.HOUR_OF_DAY));

        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        System.out.println("Etc/GMT+12 :" + calendar.get(Calendar.HOUR_OF_DAY));


    }

    @Test
    public void testDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/yyyy");
        try {
            System.out.println(sdf.parse("22/11/2310"));
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Date now = new Date("11/11/1111");
        System.out.println(now.getTime());
    }

    @Test
    public void testCalendar() {
        System.out.println(System.nanoTime());
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ":" + calendar.get(Calendar.MILLISECOND));
        System.out.println(calendar.getTime());
        System.out.println(calendar.getTimeInMillis());
    }
}
