package prod;

import org.apache.log4j.Logger;
import org.junit.Test;
import prod.bean.AbstractRecord;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by a549238 on 4/5/2017.
 */
public abstract class SQLEngine {
    private static final Logger logger = Logger.getLogger(SQLEngine.class);

    protected static final int BUFF_SIZE = 10000;
    protected static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
    protected static final String DB_DATE_FORMAT = "yyyy/MM/dd hh24:mi:ss";
    protected SimpleDateFormat dateformat = new SimpleDateFormat(DATE_FORMAT);

    public abstract void generate(List<AbstractRecord> recordList, String savedFilePath);

    protected String getValueStr(Object value) {
        if (value == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(50);
        if (Date.class.isInstance(value)) {
            return sb.append("TO_DATE('").append(dateformat.format(value)).append("','").append(DB_DATE_FORMAT).append("')").toString();
        } else if (Double.class.isInstance(value)) {
            return new BigDecimal(value.toString()).toPlainString();
        } else {
            return sb.append("'").append(value.toString().trim().replaceAll("\n|\r,","").replaceAll("'","\\'\\'").replaceAll("&","chr(38)")).append("'").toString();
        }
    }


    @Test
    public void testSSS() {
        Date now = new Date();
        logger.info(getValueStr(now));
        logger.info(getValueStr("Based on RIT6 30JUN16DRP D1 PAGE - \n" +
                "HZ Shen,Xia 30/09/2016"));
    }
}
