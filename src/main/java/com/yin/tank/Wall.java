package com.yin.tank;

import java.awt.*;

public class Wall extends GameObject{
    int w,h;
    public Rectangle rectangle;
    public Wall(int x,int y,int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rectangle = new Rectangle(x,y,w,h);
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics p) {
        Color c = p.getColor();
        p.setColor(Color.DARK_GRAY);
        p.fillRect(x,y,w,h);
        p.setColor(c);
    }
}
