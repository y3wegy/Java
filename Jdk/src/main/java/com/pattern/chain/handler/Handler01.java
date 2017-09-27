package com.pattern.chain.handler;

import com.pattern.chain.Levels;

/**
 * Created by Rui on 6/7/2016.
 */
public class Handler01 extends AbstractHandler {
    @Override
    public Levels getHandleLevel() {
        return Levels.LEVEL_01;
    }
}
