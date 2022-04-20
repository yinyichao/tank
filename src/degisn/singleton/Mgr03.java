package degisn.singleton;

/**
 * 静态内部类，可以访问私有方法
 * 静态内部类，在外部类被加载时并不会被同时加载
 * JVM保证类加载只会一次
 */
public class Mgr03 {
    private Mgr03() {

    }
    private static class Mgr03Handler {
        private final static Mgr03 INSTANCE = new Mgr03();
    }
    public static Mgr03 getInstance() {
        return Mgr03Handler.INSTANCE;
    }

    public static void main(String[] args) {
        Mgr03 m1 = Mgr03.getInstance();
        Mgr03 m2 = Mgr03.getInstance();
        System.out.println(m1 == m2);
    }
}
