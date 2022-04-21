package com.yin.tank;

import java.awt.*;

public class Bullet extends GameObject {
    private static final int SPEED = PropertyMgr.getIntegerKey("bulletSpeed");
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private Dir dir;
    private boolean living = true;
    public Group group = Group.BAD;
    public Rectangle rectangle = new Rectangle();

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        rectangle.x = x;
        rectangle.y = y;
        rectangle.height = HEIGHT;
        rectangle.width = WIDTH;

        GameModel.getInstance().add(this);
    }

    public void paint(Graphics g) {
        if (!living) {
            GameModel.getInstance().remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(Tank tank) {
        if (this.group == tank.getGroup()) return;
        if (rectangle.intersects(tank.rectangle)) {
            tank.die();
            this.die();
            int bX = tank.x + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int bY = tank.y + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            new Explode(bX, bY);
        }
    }

    public void die() {
        this.living = false;
    }
}
