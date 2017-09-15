package com.pattern.chain.handler;

import com.pattern.chain.Levels;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by a549238 on 6/7/2016.
 */
public class Handler01 extends AbstractHandler {

    private static final Logger logger = LoggerFactory.getLogger(Handler01.class);

    @Override
    public Levels getHandleLevel() {
        return Levels.LEVEL_01;
    }
}
