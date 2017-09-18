package com.jdk.date;

import org.apache.log4j.Logger;
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
public class CalendarTest {

    public static final Logger logger = Logger.getLogger(CalendarTest.class);

    @Test
    public void testTimeZone() {
        Calendar calendar = Calendar.getInstance();
        logger.info(String.format("Local time zone:%s", calendar.getTimeZone()));

        logger.info(Arrays.toString(TimeZone.getAvailableIDs()));
        calendar.setTimeZone(TimeZone.getTimeZone("Pacific/Niue"));
        logger.info(String.format("GTM+1 :%s", calendar.get(Calendar.HOUR_OF_DAY)));

        calendar.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        logger.info(String.format("Etc/GMT+12 :{%s", calendar.get(Calendar.HOUR_OF_DAY)));


    }

    @Test
    public void testDateFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/yyyy");
        try {
            logger.info(sdf.parse("22/11/2310").toString());
        } catch (ParseException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Date now = new Date("11/11/1111");
        logger.info(String.valueOf(now.getTime()));
    }

    @Test
    public void testCalendar() {
        logger.info(String.valueOf(System.nanoTime()));
        Calendar calendar = Calendar.getInstance();
        logger.info(calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND) + ":" + calendar.get(Calendar.MILLISECOND));
        logger.info(String.valueOf(calendar.getTime()));
        logger.info(String.valueOf(calendar.getTimeInMillis()));
    }
}
