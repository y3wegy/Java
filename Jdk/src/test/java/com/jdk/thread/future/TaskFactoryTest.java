/*
package com.jdk.thread.future;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiFunction;

*/
/**
 * Created by e631876 on 6/8/2017.
 *//*

public class TaskFactoryTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public  void testRunBlocking() throws ExecutionException, InterruptedException {
        Integer i1 = TaskFactory.task1(1).join();
        CompletableFuture<Integer> future2 = TaskFactory.task2(i1);
        CompletableFuture<Integer> future3 = TaskFactory.task3(i1);
        Integer result = TaskFactory.task4(future2.join() + future3.join()).join();
        CompletableFuture<Integer> res = CompletableFuture.completedFuture(result);
        System.out.println(res.get());
    }

    */
/**
     *      task1
     *      /   \
     *  task2  task3
     *      \   /
     *      task4
     *
     * @throws Exception
     *//*

    @Test
    public void testRunNonblocking() throws Exception {
        CompletableFuture<Integer> res = TaskFactory.task1(1).thenCompose(i1 -> (
                (CompletableFuture<Integer>) TaskFactory.task2(i1)
                        .thenCombine(TaskFactory.task3(i1), (i2, i3) -> i2 + i3)
        )).thenCompose(i4 -> TaskFactory.task4(i4));
        System.out.println(res.get());
    }

    */
/**
     *      task1
     *      /   \
     *  task2  task3
     *      \   /
     *      task4
     * @throws Exception
     *//*

    @Test
    public void testRunNonblockingAlt() throws Exception {
        CompletableFuture<Integer> task1 = TaskFactory.task1(1);
        CompletableFuture<Integer> comp123 = task1.thenCompose(i1 -> runSameTime(i1));
        CompletableFuture<Integer> res = comp123.thenCompose(i -> TaskFactory.task4(i));
        System.out.println(res.get());
    }

    @Test
    public void testRunNonblockingAltFailed() throws Exception {
        CompletableFuture<Integer> task1 = TaskFactory.task1(1);
        CompletableFuture<Integer> comp123 = task1.thenCompose(i1 -> runSameTime(i1));
        CompletableFuture<Integer> res = comp123.thenCompose(i -> TaskFactory.failedTask4(i));
        System.out.println(res.get());
    }

    private CompletableFuture<Integer> runSameTime(Integer value) {
        CompletableFuture<Integer> task2 = TaskFactory.task2(value);
        CompletableFuture<Integer> task3 = TaskFactory.task3(value);
        BiFunction<Integer, Integer, Integer> sumFunc = (a, b) -> a + b;
        return task2.thenCombine(task3, sumFunc);
    }
}*/
