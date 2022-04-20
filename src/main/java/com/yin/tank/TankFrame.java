package com.yin.tank;

import com.yin.tank.factory.*;
import com.yin.tank.strategy.PropertyMgrUtil;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame {
    public static final int GAME_WIDTH = PropertyMgr.getIntegerKey("gameWidth");
    public static final int GAME_HEIGHT = PropertyMgr.getIntegerKey("gameHeight");
    public GameFactory factory = new DefaultFactory();
    BaseTank myTank = factory.createTank(200,400,Dir.DOWN,Group.GOOD,this);
    public List<BaseBullet> bullets = new ArrayList<>();
    public List<BaseTank> tanks = new ArrayList<>();
    public List<BaseExplode> explodes = new ArrayList<>();
    Image offScreenImage = null;

    public TankFrame(){
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
    @Override
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
    class MyKeyListener extends KeyAdapter {
        boolean bL = false;
        boolean bR = false;
        boolean bU = false;
        boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT :
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT :
                    bR = true;
                    break;
                case KeyEvent.VK_UP :
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN :
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL :
                    myTank.fire(PropertyMgrUtil.getDefaultFire());
                    break;
                case KeyEvent.VK_A:
                    myTank.fire(PropertyMgrUtil.getFourDirFire());
                    break;
                default:break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bL && !bR && !bU && !bD) {
                myTank.setMoving(false);
            }else {
                myTank.setMoving(true);
            }

            if(bL) myTank.setDir(Dir.LEFT);
            if(bR) myTank.setDir(Dir.RIGHT);
            if(bU) myTank.setDir(Dir.UP);
            if(bD) myTank.setDir(Dir.DOWN);


        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_LEFT :
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT :
                    bR = false;
                    break;
                case KeyEvent.VK_UP :
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN :
                    bD = false;
                    break;
                default:break;
            }
            setMainTankDir();
        }
    }
}
