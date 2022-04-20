package com.yin.tank.strategy;

import com.yin.tank.Bullet;
import com.yin.tank.Tank;
import com.yin.tank.factory.BaseTank;

public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tank.getTf().factory.createBullet(bX, bY, tank.getDir(), tank.getGroup(), tank.getTf());
    }
}
