package com.yin.tank.factory;

import com.yin.tank.*;

import java.awt.*;

public class RectBullet extends BaseBullet {
    private static final int SPEED = PropertyMgr.getIntegerKey("bulletSpeed");
    private TankFrame tf;
    private int x,y;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;
    private boolean living = true;
    private Group group = Group.BAD;
    private Rectangle rectangle = new Rectangle();

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
        rectangle.x = x;
        rectangle.y = y;
        rectangle.height = HEIGHT;
        rectangle.width = WIDTH;

        tf.bullets.add(this);
    }
    public void paint(Graphics g) {
        if(!living) {
            tf.bullets.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,20,20);
        g.setColor(c);
        move();
    }
    private void move() {
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
        rectangle.x = this.x;
        rectangle.y = this.y;
        if(x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }
    @Override
    public void collideWith(BaseTank tank) {
        if(this.group == tank.getGroup()) return;
        if(rectangle.intersects(tank.rectangle)) {
            tank.die();
            this.die();
            int bX = tank.getX() + RectTank.WIDTH/2 - Explode.WIDTH/2;
            int bY = tank.getY() + RectTank.HEIGHT/2 - Explode.HEIGHT/2;
            tf.explodes.add(tf.factory.createExplode(bX,bY,tf));
        }
    }

    private void die() {
        this.living = false;
    }
}
