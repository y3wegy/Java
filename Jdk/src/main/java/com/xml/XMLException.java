package com.xml;

/**
 * Created by Chen,Rui on 9/11/2017.
 */
public class XMLException extends Exception {
    public XMLException(String msg){
        super(msg);
    }

    public XMLException(Throwable e){
        super(e);
    }
}
