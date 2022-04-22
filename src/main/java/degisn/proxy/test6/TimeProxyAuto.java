package degisn.proxy.test6;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxyAuto {
    @Before("execution(void degisn.proxy.test6.Tank.move())")
    public void before() {
        System.out.println("method start.."+System.currentTimeMillis());
    }
    @After("execution(void degisn.proxy.test6.Tank.move())")
    public void after() {
        System.out.println("method stop.."+System.currentTimeMillis());
    }
}
