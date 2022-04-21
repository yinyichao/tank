package com.yin.tank.decorator;

import com.yin.tank.GameObject;

import java.awt.*;

public abstract class GODecorator extends GameObject {
    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public void paint(Graphics p) {
        go.paint(p);
    }

}
