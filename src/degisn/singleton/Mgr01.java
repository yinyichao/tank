package degisn.singleton;

/**
 * 饿汉式
 * Class.forName()
 */
public class Mgr01 {
    private Mgr01() {

    }
    private static final Mgr01 INSTANCE = new Mgr01();

    public static Mgr01 getInstance() {
        return INSTANCE;
    }
    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Mgr01 mgr01 = Mgr01.getInstance();
        Mgr01 mgr02 = Mgr01.getInstance();
        System.out.println(mgr01==mgr02);
    }
}
