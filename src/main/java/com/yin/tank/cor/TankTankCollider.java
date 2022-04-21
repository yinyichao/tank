package com.yin.tank.cor;

import com.yin.tank.GameObject;
import com.yin.tank.Tank;

public class TankTankCollider extends Collider {
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if(t1.getRectangle().intersects(t2.getRectangle())) {
                t1.stop();
                t2.stop();
            }
        }
        return true;
    }
}
