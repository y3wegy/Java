package com.view;

import java.awt.*;

/**
 * Created by a549238 on 8/19/2015.
 */
public class BufferMovingCircle extends NoBufferMovingCircle {
    Graphics doubleBuffer = null;

    public void init() {
        super.init();
        doubleBuffer = screenImage.getGraphics();
    }

    public void paint(Graphics g) {
        doubleBuffer.setColor(Color.white);
        doubleBuffer.fillRect(0, 0, 200, 100);
        drawCircle(doubleBuffer);
        g.drawImage(screenImage, 0, 0, this);
    }
}
