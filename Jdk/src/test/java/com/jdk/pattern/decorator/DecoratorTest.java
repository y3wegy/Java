package com.jdk.pattern.decorator;

import com.pattern.decorator.BlankRoom;
import com.pattern.decorator.decorated.FlooredDecorator;
import com.pattern.decorator.decorated.PaintedDecorator;
import org.junit.Test;

/**
 * Created by Rui on 3/24/2016.
 */
public class DecoratorTest {
    @Test
    public void testRoom() throws Exception {
        new FlooredDecorator(new PaintedDecorator(new BlankRoom())).showRoom();
    }
}
