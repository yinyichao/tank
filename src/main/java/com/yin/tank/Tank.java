package com.yin.tank;

import com.yin.tank.factory.BaseTank;
import com.yin.tank.strategy.FireStrategy;
import com.yin.tank.strategy.PropertyMgrUtil;

import java.awt.*;
import java.util.Random;

public class Tank extends BaseTank {
    private boolean living = true;
    private Random random = new Random();


    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super(x,y,group,dir,tf);
        rectangle.x = x;
        rectangle.y = y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.tanks.remove(this);
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

    /*private void boundsCheck() {
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
    }*/

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
