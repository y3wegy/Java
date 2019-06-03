import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class ThreadTest {
    private static AtomicLong count = new AtomicLong();
    private static LongAdder longAdder = new LongAdder();



    @Test
    void testPerformance() throws InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,12,10, TimeUnit.SECONDS, new LinkedBlockingQueue());
       /* for(int i =1;i<12;i++){
            poolExecutor.submit(new AtomicCallable(count));
        }*/

        for(int i =1;i<12;i++){
            poolExecutor.submit(new AdderCallable(longAdder));
        }
        poolExecutor.shutdown();
        while (!poolExecutor.awaitTermination(10,TimeUnit.SECONDS));
    }
}

class AtomicCallable implements Callable<Boolean>{
    private static final Logger logger = Logger.getLogger(AtomicCallable.class);
    private AtomicLong atomicLong;

    public AtomicCallable(AtomicLong atomicLong) {
        this.atomicLong = atomicLong;
    }

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(1000);
        logger.info(atomicLong.getAndIncrement());
        return null;
    }
}

class AdderCallable implements Callable<Boolean>{
    private static final Logger logger = Logger.getLogger(AdderCallable.class);
    private LongAdder longAdder;

    public AdderCallable(LongAdder longAdder) {
        this.longAdder = longAdder;
    }

    @Override
    public Boolean call() throws Exception {
        longAdder.increment();
        logger.info(longAdder.longValue());
        return null;
    }
}
