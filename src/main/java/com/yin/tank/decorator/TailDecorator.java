package com.yin.tank.decorator;

import com.yin.tank.GameObject;

import java.awt.*;

public class TailDecorator extends GODecorator{
    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics p) {
        x = go.getX();
        y = go.getY();
        go.paint(p);

        Color c = p.getColor();
        p.setColor(Color.YELLOW);
        p.drawLine(super.go.getX(),super.go.getY(),super.go.getX()+getWidth(),super.go.getY()+getHeight());
        p.setColor(c);
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }
}
