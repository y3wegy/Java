package com.jdk.thread;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Thread Factory Test
 */
public class ThreadPoolFactoryTest {

    private static final Logger logger = Logger.getLogger(ThreadPoolFactoryTest.class);

    /**
     * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
     */
    @Test
    public void testCachedPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    logger.info(index);
                }
            });
        }
        cachedThreadPool.shutdown();
    }

    /**
     * 创建一个定长线程池，支持定时及周期性任务执行
     */
    @Test
    public void testDelayScheduledPool() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.schedule(new Runnable() {
            public void run() {
                logger.info("delay 3 seconds");
            }
        }, 3, TimeUnit.SECONDS);

        Thread.sleep(20 * 1000);
        scheduledThreadPool.shutdown();
    }

    /**
     * delay and scheduler
     *
     * @throws InterruptedException
     */
    @Test
    public void testScheduledPool() throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                logger.info("delay 1 seconds, and excute every 3 seconds");
            }
        }, 1, 3, TimeUnit.SECONDS);
        Thread.sleep(20 * 1000);
        scheduledThreadPool.shutdown();
    }

    @Test
    public void testSingledPool() throws InterruptedException {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        logger.info(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(11*2000);
        singleThreadExecutor.shutdown();
    }
}
