package com.yin.tank.factory;

import com.yin.tank.ResourceMgr;
import com.yin.tank.TankFrame;

import java.awt.*;

public class RectExplode extends BaseExplode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private TankFrame tf;
    private int x, y;

    private int step = 0;

    public RectExplode(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step,10*step);
        if(step >= 15) {
            tf.explodes.remove(this);
        }
        step++;
        g.setColor(c);
    }
}
