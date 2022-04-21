package com.yin.tank.observer;

import com.yin.tank.Tank;
import com.yin.tank.strategy.DefaultFireStrategy;

public class TankFireHandle extends TankFireObserver {
    @Override
    public void actionOnFire(TankFireEvent event) {
        ((Tank)event.getSource()).fire(new DefaultFireStrategy());
    }
}
