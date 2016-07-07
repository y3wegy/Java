package com.jdk.pattern.decorator.decorated;

import com.jdk.pattern.decorator.Room;
import com.jdk.pattern.decorator.RoomDecorator;

/**
 * Created by a549238 on 3/24/2016.
 */
public class PaintedDecorator extends RoomDecorator {
    public PaintedDecorator(Room roomToBeDecorated) {
        super(roomToBeDecorated);
    }

    @Override
    public String showRoom() {

        return super.showRoom() + doPaint();
    }

    private String doPaint() {
        return "Painted";
    }
}
