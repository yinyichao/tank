package com.yin.tank;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class GameObject {
    @Getter
    @Setter
    protected int x;
    @Getter
    @Setter
    protected int y;
    public abstract void paint(Graphics p);
    public abstract int getHeight();
    public abstract int getWidth();

}
