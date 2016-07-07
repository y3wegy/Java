package com.jdk.runcommand;

/**
 * Created with IntelliJ IDEA.
 * User: a549238
 * Date: 12/5/13
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class OSExecuteException extends RuntimeException {
    public OSExecuteException(String why) {
        super(why);
    }
}
