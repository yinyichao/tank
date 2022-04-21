package com.yin.tank;

import com.yin.tank.cor.ColliderChain;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    @Getter
    Tank myTank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    ColliderChain chain = new ColliderChain();
    private List<GameObject> objects = new ArrayList<>();
    public void add(GameObject go) {
        objects.add(go);
    }
    public void remove(GameObject go) {
        objects.remove(go);
    }

    public GameModel() {
        int initTankCount = PropertyMgr.getIntegerKey("initTankCount");
        for(int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i * 80,200,Dir.DOWN,Group.BAD,this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        /*g.drawString("子弹数量："+bullets.size(),10,60);
        g.drawString("敌人数量："+tanks.size(),10,80);
        g.drawString("爆炸数量："+explodes.size(),10,100);*/
        g.setColor(c);
        myTank.paint(g);
        for(int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        //碰撞检测
        for(int i = 0; i < objects.size(); i++) {
            for(int j = 1; j < objects.size(); j++) {
                chain.collider(objects.get(i),objects.get(j));
            }
        }

    }
}
