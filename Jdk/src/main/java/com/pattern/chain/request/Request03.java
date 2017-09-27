package com.pattern.chain.request;

import com.pattern.chain.Levels;

/**
 * Created by Rui on 6/7/2016.
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
