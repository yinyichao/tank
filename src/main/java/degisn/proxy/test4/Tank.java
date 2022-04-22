package degisn.proxy.test4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
 * 如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型Object
 * （毕竟日志记录，时间计算是很多方法都需要的东西），这时该怎么做呢？
 * 分离代理行为与被代理对象
 * 使用jdk的动态代理
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
        //jdk 8+
        //System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),Tank.class.getInterfaces(),new TankHandle(new Tank()));
        m.move();
    }
}
class TankHandle implements InvocationHandler {
    private Object target;

    public TankHandle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object o = method.invoke(target,args);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return o;
    }
}

interface Movable {
    void move();
}
