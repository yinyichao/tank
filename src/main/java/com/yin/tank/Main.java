package com.yin.tank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int initTankCount = PropertyMgr.getIntegerKey("initTankCount");
        TankFrame frame = new TankFrame();
        for(int i = 0; i < initTankCount; i++) {
            frame.tanks.add(frame.factory.createTank(50 + i * 80,200,Dir.DOWN,Group.BAD,frame));
        }
        while(true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
