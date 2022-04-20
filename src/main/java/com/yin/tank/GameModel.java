package com.yin.tank;

import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    @Getter
    Tank myTank = new Tank(200,400,Dir.DOWN,Group.GOOD,this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    @Getter
    List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        int initTankCount = PropertyMgr.getIntegerKey("initTankCount");
        for(int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i * 80,200,Dir.DOWN,Group.BAD,this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹数量："+bullets.size(),10,60);
        g.drawString("敌人数量："+tanks.size(),10,80);
        g.drawString("爆炸数量："+explodes.size(),10,100);
        g.setColor(c);
        myTank.paint(g);
        for(int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        for(int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        //碰撞时爆炸
        for(int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }
        for(int i = 0; i < bullets.size(); i++) {
            for(int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

    }
}
