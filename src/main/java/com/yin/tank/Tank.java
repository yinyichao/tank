package com.yin.tank;

import com.yin.tank.strategy.FireStrategy;
import com.yin.tank.strategy.PropertyMgrUtil;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Random;

public class Tank {
    private static final int SPEED = PropertyMgr.getIntegerKey("tankSpeed");
    public Rectangle rectangle = new Rectangle();
    @Getter
    private int x = 200, y = 200;
    @Setter
    @Getter
    private Dir dir = Dir.DOWN;
    @Setter
    private boolean moving = true;
    private boolean living = true;
    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();
    private Random random = new Random();
    @Getter
    private Group group = Group.BAD;
    @Getter
    private GameModel gm;

    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.gm = gm;
        this.group = group;
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if (!living) {
            gm.tanks.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(group == Group.BAD ? ResourceMgr.badTankL : ResourceMgr.goodTankL, x, y, null);
                break;
            case UP:
                g.drawImage(group == Group.BAD ? ResourceMgr.badTankU : ResourceMgr.goodTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(group == Group.BAD ? ResourceMgr.badTankR : ResourceMgr.goodTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(group == Group.BAD ? ResourceMgr.badTankD : ResourceMgr.goodTankD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (group == Group.BAD && random.nextInt(100) > 95) {
            this.fire(PropertyMgrUtil.getDefaultFire());
        }
        if (group == Group.BAD) {
            randomDir();
        }
        boundsCheck();
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundsCheck() {
        if (x < 0) {
            x = 0;
        }
        if (y < 30) {
            y = 30;
        }
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH;
        }
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT;
        }
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire(FireStrategy st) {
        st.fire(this);
    }

    public void die() {
        this.living = false;
    }
}