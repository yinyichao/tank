package com.yin.tank.strategy;

import com.yin.tank.Bullet;
import com.yin.tank.Tank;

public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        new Bullet(bX, bY, tank.getDir(), tank.getGroup(), tank.getTf());
    }
}