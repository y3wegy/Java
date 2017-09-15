package com.jdk.pattern.decorator;

import com.jdk.bean.pattern.decorator.BlankRoom;
import com.jdk.bean.pattern.decorator.decorated.FlooredDecorator;
import com.jdk.bean.pattern.decorator.decorated.PaintedDecorator;
import org.junit.Test;

/**
 * Created by a549238 on 3/24/2016.
 */
public class DecoratorTest {
    @Test
    public void testRoom() throws Exception {
        new FlooredDecorator(new PaintedDecorator(new BlankRoom())).showRoom();
    }
}
