package degisn.proxy.test6;

public class TimeProxy {
    public void before() {
        System.out.println("method start.."+System.currentTimeMillis());
    }
    public void after() {
        System.out.println("method stop.."+System.currentTimeMillis());
    }
}
