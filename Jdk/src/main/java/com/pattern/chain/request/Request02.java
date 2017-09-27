package com.pattern.chain.request;

import com.pattern.chain.Levels;

/**
 * Created by Rui on 6/7/2016.
 */
public class Request02 extends AbstractRequest {

    public Request02(String content) {
        super(content);
    }

    @Override
    public Levels getLevel() {
        return Levels.LEVEL_02;
    }
}
