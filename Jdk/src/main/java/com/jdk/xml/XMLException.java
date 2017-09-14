package com.jdk.xml;

/**
 * Created by e631876 on 9/11/2017.
 */
public class XMLException extends Exception {
    public XMLException(String msg){
        super(msg);
    }

    public XMLException(Throwable e){
        super(e);
    }
}
