package com.pattern.decorator;

/**
 * Created by Rui on 3/24/2016.
 */
public abstract class RoomDecorator implements Room {

    protected Room roomToBeDecorated;

    public RoomDecorator(Room roomToBeDecorated) {
        this.roomToBeDecorated = roomToBeDecorated;
    }

    @Override
    public String showRoom() {
        return this.roomToBeDecorated.showRoom();
    }
}
