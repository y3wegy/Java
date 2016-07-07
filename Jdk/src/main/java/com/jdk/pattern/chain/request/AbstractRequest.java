package com.jdk.pattern.chain.request;

import com.jdk.pattern.chain.Levels;

/**
 * Created by a549238 on 6/7/2016.
 */
public abstract class AbstractRequest {
    private String content = null;

    public AbstractRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public abstract Levels getLevel();
}
