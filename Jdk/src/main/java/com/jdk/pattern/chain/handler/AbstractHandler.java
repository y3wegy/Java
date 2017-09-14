package com.jdk.pattern.chain.handler;

import com.jdk.pattern.chain.Levels;
import com.jdk.pattern.chain.request.AbstractRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by a549238 on 6/7/2016.
 */
public abstract class AbstractHandler {

    private static Logger logger = LoggerFactory.getLogger(AbstractHandler.class);

    private AbstractHandler nextHandler = null;

    public final void handle(AbstractRequest request) {
        if (this.getHandleLevel() == request.getLevel()) {
            this.handeRequest(request);
        } else {
            if (this.nextHandler != null) {
                logger.info("current handler {} can not handle {}",this.getHandleLevel(),request.getLevel());
                this.nextHandler.handle(request);
            } else {
                logger.info("All handler can not handle this request!");
            }
        }
    }

    protected void handeRequest(AbstractRequest request) {
        logger.info("{} handle {}",getHandleLevel(),request.getContent());
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract Levels getHandleLevel();
}
