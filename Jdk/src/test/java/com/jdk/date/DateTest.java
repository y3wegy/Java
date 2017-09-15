package com.jdk.date;

import oracle.sql.TIMESTAMP;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by a549238 on 4/27/2015.
 */
public class DateTest {
    private static final Logger logger = LoggerFactory.getLogger(DateTest.class);
    @Test
    public void testCalendar2SqlTimestamp() {
        Calendar calendar = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(calendar.getTime().getTime());
        Timestamp timestamp1 = new Timestamp(calendar.getTimeInMillis());
        logger.info("time and time:{}",timestamp.toString());
        logger.info("getTimeInMillis:{}", timestamp1.toString());
        logger.info(Timestamp.valueOf("2015-09-08 12:00:00").toString());
    }

    @Test
    public void testCompare() {
        Calendar base = Calendar.getInstance();
        base.set(Calendar.HOUR_OF_DAY, 19);

        Calendar calendar = Calendar.getInstance();

        logger.info(base.getTime() + " ;  " + calendar.getTime());


        base.set(Calendar.HOUR_OF_DAY, 17);
        logger.info(String.valueOf(calendar.after(base)));
    }

    @Test
    public void testFormat() {
        SimpleDateFormat fd = new SimpleDateFormat("DD-MMM-YYYY");
        try {
            logger.info(fd.parse("01-JAN-2016").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOrcaleCase()
    {
        TIMESTAMP timestamp = new TIMESTAMP(new Timestamp(new Date().getTime()));
        if(timestamp instanceof TIMESTAMP)
        {
            try {
                logger.info(((TIMESTAMP)timestamp).timestampValue().toString());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 29);
        logger.info("now " + calendar.getTime());
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 30);
        assertEquals("a", "a");
        logger.info("now " + calendar.getTime());

    }
}
