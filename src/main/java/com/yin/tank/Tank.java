package com.yin.tank;

import com.yin.tank.strategy.FireStrategy;
import com.yin.tank.strategy.PropertyMgrUtil;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObject {
    private static final int SPEED = PropertyMgr.getIntegerKey("tankSpeed");
    @Getter
    public Rectangle rectangle = new Rectangle();
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
    private int oldX;
    private int oldY;

    public Tank(int x, int y, Dir dir, Group group) {
        oldX = x;
        oldY = y;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
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

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    public void stop() {
        moving = false;
    }

    private void move() {
        oldX = x;
        oldY = y;
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
        if (group == Group.BAD && random.nextInt(100) > 95) {
            randomDir();
        }
        boundsCheck();
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void boundsCheck() {
        if (x < 2) {
            x = 2;
        }
        if (y < 28) {
            y = 28;
        }
        if (x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) {
            x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        }
        if (y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) {
            y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
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

    public void back() {
        this.x = oldX;
        this.y = oldY;
    }
}
