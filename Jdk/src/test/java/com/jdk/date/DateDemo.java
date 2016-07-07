package com.jdk.date;

import oracle.sql.TIMESTAMP;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by a549238 on 4/27/2015.
 */
public class DateDemo {
    @Test
    public void testCalendar2SqlTimestamp() {
        Calendar calendar = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        Timestamp timestamp1 = new Timestamp(calendar.getTimeInMillis());
        System.out.println("time and time:" + timestamp);
        System.out.println("getTimeInMillis:" + timestamp1);
        System.out.println(Timestamp.valueOf("2015-09-08 12:00:00"));
    }

    @Test
    public void testCompare() {
        Calendar base = Calendar.getInstance();
        base.set(Calendar.HOUR_OF_DAY, 19);

        Calendar calendar = Calendar.getInstance();

        System.out.println(base.getTime() + " ;  " + calendar.getTime());


        base.set(Calendar.HOUR_OF_DAY, 17);
        System.out.println(calendar.after(base));
    }

    @Test
    public void testFormat() {
        SimpleDateFormat fd = new SimpleDateFormat("DD-MMM-YYYY");
        try {
            System.out.println(fd.parse("01-JAN-2016"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOrcaleCase()
    {
        Calendar calendar = Calendar.getInstance();
        TIMESTAMP timestamp = new TIMESTAMP(new Timestamp(new Date().getTime()));
        if(timestamp instanceof TIMESTAMP)
        {
            try {
                System.out.println(((TIMESTAMP)timestamp).timestampValue());
            } catch (SQLException e) {
                e.printStackTrace();
            }

           // System.out.println(((Date)timestamp).getTime());
        }
    }
}
