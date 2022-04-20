package com.yin.tank.strategy;

import com.yin.tank.Bullet;
import com.yin.tank.Dir;
import com.yin.tank.Tank;
import com.yin.tank.factory.BaseTank;

public class FourDirFireStrategy implements FireStrategy {

    @Override
    public void fire(BaseTank tank) {
        int bX = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Dir[] dirs = Dir.values();
        for (int i = 0; i < dirs.length; i++) {
            tank.getTf().factory.createBullet(bX, bY, dirs[i], tank.getGroup(), tank.getTf());
        }
    }
}
