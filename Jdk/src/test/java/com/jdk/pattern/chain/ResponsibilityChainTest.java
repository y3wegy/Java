package com.jdk.pattern.chain;

import com.pattern.chain.handler.AbstractHandler;
import com.pattern.chain.handler.Handler01;
import com.pattern.chain.handler.Handler02;
import com.pattern.chain.handler.Handler03;
import com.pattern.chain.request.AbstractRequest;
import com.pattern.chain.request.Request01;
import com.pattern.chain.request.Request02;
import com.pattern.chain.request.Request03;
import org.junit.Test;

/**
 * Created by a549238 on 6/7/2016.
 */
public class ResponsibilityChainTest {
    @Test
    public void testChain() {
        AbstractRequest request01 = new Request01("Request 01");
        AbstractRequest request02 = new Request02("Request 02");
        AbstractRequest request03 = new Request03("Request 03");

        AbstractHandler handler01 = new Handler01();
        AbstractHandler handler02 = new Handler02();
        AbstractHandler handler03 = new Handler03();

        handler01.setNextHandler(handler02);
        handler02.setNextHandler(handler03);

        handler01.handle(request01);
        handler01.handle(request02);
        handler01.handle(request03);

    }
}
