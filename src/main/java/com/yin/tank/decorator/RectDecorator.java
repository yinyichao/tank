package com.yin.tank.decorator;

import com.yin.tank.GameObject;

import java.awt.*;

public class RectDecorator extends GODecorator{
    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics p) {
        x = go.getX();
        y = go.getY();
        go.paint(p);

        Color c = p.getColor();
        p.setColor(Color.YELLOW);
        p.drawRect(super.go.getX(),super.go.getY(),getWidth(),getHeight());
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
