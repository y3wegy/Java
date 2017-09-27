package com.view;

import java.awt.*;

/**
 * Created by Rui on 8/19/2015.
 */
public class BufferMovingCircle extends NoBufferMovingCircle {
    private transient Graphics doubleBuffer = null;

    @Override
    public void init() {
        super.init();
        doubleBuffer = screenImage.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        doubleBuffer.setColor(Color.white);
        doubleBuffer.fillRect(0, 0, 200, 100);
        drawCircle(doubleBuffer);
        g.drawImage(screenImage, 0, 0, this);
    }
}
