package com.yin.tank.factory;

import com.yin.tank.*;
import com.yin.tank.strategy.FireStrategy;
import com.yin.tank.strategy.PropertyMgrUtil;

import java.awt.*;
import java.util.Random;

public class RectTank extends BaseTank{
    private boolean living = true;
    private Random random = new Random();

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
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
        Color c = g.getColor();
        g.setColor(group == Group.BAD ? Color.YELLOW : Color.RED);
        g.fillRect(x,y,40,40);
        g.setColor(c);
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
        super.boundsCheck();
        rectangle.x = this.x;
        rectangle.y = this.y;
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
