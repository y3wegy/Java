import org.apache.log4j.Logger;

/**
 * Created by a549238 on 3/15/2016.
 */
public class Child extends Father {

    private static final Logger logger = Logger.getLogger(Child.class);
    @Override
    protected void fun()
    {
        logger.info("Child");
    }
}
