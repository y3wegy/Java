package com.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by a549238 on 5/29/2015.
 */
public class Demo {

    private static final Logger logger = LoggerFactory.getLogger(Demo.class);

    private static final String[] DATE_LABELS = new String[]{"LAST_UPDATE_DATE", "START_TIME", "END_TIME"};


    @Test
    public void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("123");
        sb.delete(0, sb.length());
        logger.info("1212:" + sb.toString());

        StringBuffer sf = new StringBuffer();
        sf.append("12");
    }

    @Test
    public void testDateFormat() throws Exception {
        SimpleDateFormat fm = new SimpleDateFormat("'.Y'yyyy'.D'MMdd'.'kkmmss'.'");
        String mArchDate = fm.format(Calendar.getInstance().getTime());
        logger.info(mArchDate);
    }

    @Test
    public void testFormart() throws Exception {
        String str= String.format("%s prepare empty excel file completed", 'A');
        logger.info(str);

    }
}
