import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by a549238 on 3/15/2016.
 */
public class Child extends Father {

    private static final Logger logger = LoggerFactory.getLogger(Child.class);
    @Override
    protected void fun()
    {
        logger.info("Child");
    }
}
