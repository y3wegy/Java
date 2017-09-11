package com.jdk.thread.future;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CompletableFuture;

/**
 * Created by e631876 on 6/8/2017.
 */

public class TimedEventSupport {

    private TimedEventSupport() {
    }

    private static final Timer timer = new Timer();

    public static<T> CompletableFuture<T> delayedSuccess(int delay,T value){
        CompletableFuture<T> future = new CompletableFuture<>();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                future.complete(value);
            }
        };
        timer.schedule(task,delay*1000);
        return future;
    }

    public static<T> CompletableFuture<T> delayedfailure(int delay,Throwable t){
        CompletableFuture<T> future = new CompletableFuture<>();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                future.completeExceptionally(t);
            }
        };
        timer.schedule(task,delay*1000);
        return future;
    }

}