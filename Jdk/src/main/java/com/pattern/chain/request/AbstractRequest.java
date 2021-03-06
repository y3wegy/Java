package com.pattern.chain.request;

import com.pattern.chain.Levels;

/**
 * Created by Rui on 6/7/2016.
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
