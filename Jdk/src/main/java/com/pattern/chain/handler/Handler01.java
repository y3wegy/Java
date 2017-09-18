package com.pattern.chain.handler;

import com.pattern.chain.Levels;
import org.apache.log4j.Logger;

/**
 * Created by a549238 on 6/7/2016.
 */
public class Handler01 extends AbstractHandler {

    private static final Logger logger = Logger.getLogger(Handler01.class);

    @Override
    public Levels getHandleLevel() {
        return Levels.LEVEL_01;
    }
}
