package com.yin.tank.cor;

import com.yin.tank.GameObject;
import com.yin.tank.Tank;
import com.yin.tank.Wall;

public class TankWallCollider extends Collider{
    @Override
    public boolean collider(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Wall) {
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;
            if(t.rectangle.intersects(w.rectangle)) {
                t.back();
            }
        }else if(o1 instanceof Wall && o2 instanceof Tank) {
            return collider(o2,o1);
        }
        return true;
    }
}
