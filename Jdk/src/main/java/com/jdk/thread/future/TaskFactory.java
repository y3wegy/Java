package com.jdk.thread.future;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Chen,Rui on 6/8/2017.
 */
public class TaskFactory {
    private TaskFactory() {
    }

    public static CompletableFuture<Integer> task1(int input) {
        return TimedEventSupport.delayedSuccess(1, input + 1);
    }

    public static CompletableFuture<Integer> task2(int input) {
        return TimedEventSupport.delayedSuccess(2, input + 2);
    }

    public static CompletableFuture<Integer> task3(int input) {
        return TimedEventSupport.delayedSuccess(3, input + 3);
    }

    public static CompletableFuture<Integer> task4(int input) {
        return TimedEventSupport.delayedSuccess(1, input + 4);
    }

    public static CompletableFuture<Integer> failedTask4(int input){
        return TimedEventSupport.delayedfailure(1,new IllegalArgumentException("This does not work!"));
    }
}
