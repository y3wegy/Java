package com.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by a549238 on 8/19/2015.
 */
public class NoBufferMovingCircle extends JApplet implements Runnable {

    Image screenImage = null;
    Thread thread;
    int x = 5;
    int move = 1;

    public void init() {
        screenImage = createImage(230, 160);
    }

    public void start() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {

        try {
            System.out.println(x);
            while (true) {
                x += move;
                if (x > 105 || x < 5)
                    move *= -1;
                repaint();
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void drawCircle(Graphics gc) {
        Graphics2D graphics2D = (Graphics2D) gc;
        graphics2D.setColor(Color.green);
        graphics2D.fillRect(0, 0, 200, 100);
        graphics2D.setColor(Color.RED);
        graphics2D.fillOval(x, 5, 90, 90);
    }

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, 200, 100);
        drawCircle(g);
    }
}

