import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by a549238 on 3/15/2016.
 */
public class TestChild {
    @Test
    public void testsss()
    {
        Father father = new SubChild();
        father.fun();
    }

    @Test
    public void testFFF()
    {
        System.out.println(false||true&&false);
    }

    @Test
    public void testDate()
    {
        System.out.println(new Date());
        System.out.println(new java.sql.Timestamp(((new Date()).getTime())));
    }

    @Test
    public void testSSS()
    {
        List<String> s= new ArrayList<String>();
        s.add("1");
        s.add("2");
        System.out.println(org.apache.commons.lang.StringUtils.join(s.toArray(),","));
    }

}
