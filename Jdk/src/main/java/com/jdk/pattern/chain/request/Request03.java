package com.jdk.pattern.chain.request;

import com.jdk.pattern.chain.Levels;

/**
 * Created by a549238 on 6/7/2016.
 */
public class Request03 extends AbstractRequest {
    public Request03(String content) {
        super(content);
    }

    @Override
    public Levels getLevel() {
        return Levels.LEVEL_03;
    }
}