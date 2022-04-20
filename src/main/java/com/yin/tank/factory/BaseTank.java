package com.yin.tank.factory;

import com.yin.tank.*;
import com.yin.tank.strategy.FireStrategy;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class BaseTank {
    public static final int SPEED = PropertyMgr.getIntegerKey("tankSpeed");
    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();
    @Getter
    @Setter
    public int x = 200;
    @Getter
    @Setter
    public int y = 200;
    @Getter
    @Setter
    public Group group = Group.BAD;
    @Getter
    @Setter
    public Dir dir = Dir.DOWN;
    @Getter
    @Setter
    public TankFrame tf;
    public Rectangle rectangle = new Rectangle();
    @Getter
    @Setter
    public boolean moving = true;
    public BaseTank(int x, int y, Group group, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.group = group;
        this.dir = dir;
        this.tf = tf;
    }

    public abstract void paint(Graphics g);

    protected void boundsCheck() {
        if (x < 0) {
            x = 0;
        }
        if (y < 30) {
            y = 30;
        }
        if (x > TankFrame.GAME_WIDTH - RectTank.WIDTH) {
            x = TankFrame.GAME_WIDTH - RectTank.WIDTH;
        }
        if (y > TankFrame.GAME_HEIGHT - RectTank.HEIGHT) {
            y = TankFrame.GAME_HEIGHT - RectTank.HEIGHT;
        }
    }
    public abstract void die();
    public abstract void fire(FireStrategy st);
}
