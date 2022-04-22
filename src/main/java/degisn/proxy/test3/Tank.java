package degisn.proxy.test3;

import java.util.Random;

/**
 * 问题：我想记录坦克的移动时间
 * 最简单的办法：修改代码，记录时间
 * 问题2：如果无法改变方法原码呢？benchmark
 * 继承？
 * 使用代理解决
 * 代理有各种类型
 * 问题3：如何实现代理的各种组合？继承？Decorator？
 * 静态代理
 * 代理的对象改成Movable类型--越来越像decorator了
 */
public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new TankLogProxy(new Tank())).move();
    }
}

class TankTimeProxy implements Movable {
    Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class TankLogProxy implements Movable {
    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("log begin");
        movable.move();
        System.out.println("log end");
    }
}

interface Movable {
    void move();
}
