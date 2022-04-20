package com.yin.tank.factory;

import com.yin.tank.Dir;
import com.yin.tank.Group;
import com.yin.tank.TankFrame;

public class RectFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }
}
