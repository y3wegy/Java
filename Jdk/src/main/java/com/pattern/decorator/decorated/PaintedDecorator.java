package com.pattern.decorator.decorated;

import com.pattern.decorator.Room;
import com.pattern.decorator.RoomDecorator;

/**
 * Created by Rui on 3/24/2016.
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
