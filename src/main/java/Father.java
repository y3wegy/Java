import org.apache.log4j.Logger;

/**
 * Created by a549238 on 3/15/2016.
 */
public class Father {
    public static final Logger logger = Logger.getLogger(Father.class);
    private static final String MSG = "Father funA";

    protected void fun() {
        logger.info("No action ");
    }

    protected static void enter() {
        logger.info(funA());
    }

    protected static String funA() {
        return MSG;
    }
}
