package com.pattern.decorator.decorated;

import com.pattern.decorator.Room;
import com.pattern.decorator.RoomDecorator;

/**
 * Created by Rui on 3/24/2016.
 */
public class FlooredDecorator extends RoomDecorator {
    public FlooredDecorator(Room roomToBeDecorated) {
        super(roomToBeDecorated);
    }

    @Override
    public String showRoom() {
        return super.showRoom() + doFloor();
    }

    private String doFloor() {
        return "Floored";
    }
}
