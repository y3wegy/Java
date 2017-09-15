package com.jdk.bean.pattern.chain.handler;

import com.jdk.bean.pattern.chain.Levels;
import com.jdk.bean.pattern.chain.request.AbstractRequest;
import org.apache.log4j.Logger;

/**
 * Created by a549238 on 6/7/2016.
 */
public abstract class AbstractHandler {

    private static Logger logger = org.apache.log4j.Logger.getLogger(AbstractHandler.class);

    private AbstractHandler nextHandler = null;

    public final void handle(AbstractRequest request) {
        if (this.getHandleLevel() == request.getLevel()) {
            this.handeRequest(request);
        } else {
            if (this.nextHandler != null) {
                logger.info(String.format("current handler %s can not handle %s",this.getHandleLevel(),request.getLevel()));
                this.nextHandler.handle(request);
            } else {
                logger.info("All handler can not handle this request!");
            }
        }
    }

    protected void handeRequest(AbstractRequest request) {
        logger.info(String.format("%s handle %s",getHandleLevel(),request.getContent()));
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract Levels getHandleLevel();
}
