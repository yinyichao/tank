package com.yin.tank.observer;

import com.yin.tank.Tank;
import com.yin.tank.strategy.DefaultFireStrategy;

import java.io.Serializable;

public class TankFireHandle extends TankFireObserver implements Serializable {
    @Override
    public void actionOnFire(TankFireEvent event) {
        ((Tank)event.getSource()).fire(new DefaultFireStrategy());
    }
}
