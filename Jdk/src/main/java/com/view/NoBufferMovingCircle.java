package com.view;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Rui on 8/19/2015.
 */
public class NoBufferMovingCircle extends JApplet implements Runnable {

    public static final Logger logger =Logger.getLogger(NoBufferMovingCircle.class);
    transient Image screenImage = null;
    transient Thread thread;
    int xPosition = 5;
    int move = 1;

    @Override
    public void init() {
        screenImage = createImage(230, 160);
    }

    @Override
    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {

        try {
            logger.info(xPosition);
            while (true) {
                xPosition += move;
                if (xPosition > 105 || xPosition < 5)
                    move *= -1;
                repaint();
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            logger.error(e);
            Thread.currentThread().interrupt();
        }
    }

    public void drawCircle(Graphics gc) {
        Graphics2D graphics2D = (Graphics2D) gc;
        graphics2D.setColor(Color.green);
        graphics2D.fillRect(0, 0, 200, 100);
        graphics2D.setColor(Color.RED);
        graphics2D.fillOval(xPosition, 5, 90, 90);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 100);
        drawCircle(g);
    }
}

