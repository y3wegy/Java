package com.jdk.pattern.chain.request;

import com.jdk.pattern.chain.Levels;

/**
 * Created by a549238 on 6/7/2016.
 */
public class Request01 extends AbstractRequest {

    public Request01(String content) {
        super(content);
    }

    @Override
    public Levels getLevel() {
        return Levels.LEVEL_01;
    }
}
