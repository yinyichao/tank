package com.yin.tank;

import com.yin.tank.cor.ColliderChain;
import lombok.Getter;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GameModel {
    @Getter
    Tank myTank;
    ColliderChain chain = new ColliderChain();
    private List<GameObject> objects = new ArrayList<>();

    public void add(GameObject go) {
        objects.add(go);
    }

    public void remove(GameObject go) {
        objects.remove(go);
    }

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    public static GameModel getInstance() {
        return INSTANCE;
    }

    private GameModel() {

    }

    public void init() {
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);
        int initTankCount = PropertyMgr.getIntegerKey("initTankCount");
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }
        new Wall(150, 150, 200, 50);
        new Wall(550, 150, 200, 50);
        new Wall(300, 300, 50, 200);
        new Wall(550, 300, 50, 200);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }
        //碰撞检测
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                chain.collider(objects.get(i), objects.get(j));
            }
        }

    }

    public void save() {
        File file = new File("D:\\test\\tank.data");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));) {
            oos.writeObject(myTank);
            oos.writeObject(objects);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        File file = new File("D:\\test\\tank.data");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));) {
            myTank = (Tank) ois.readObject();
            objects = (List<GameObject> ) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
