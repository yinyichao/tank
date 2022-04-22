package degisn.proxy.test5;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
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
 * cglib【底层ASM实现】
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
        Enhancer enhancer = new Enhancer();
        //生成的是Tank类的子类【final的类就无法使用了，ASM可以实现】
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TankTimeInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }
}

class TankTimeInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(o,objects);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return result;
    }
}

interface Movable {
    void move();
}
