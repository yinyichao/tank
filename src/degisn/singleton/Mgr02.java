package degisn.singleton;

/**
 * 懒汉式
 * 双重判断
 * DLC
 */
public class Mgr02 {
    private static volatile Mgr02 INSTANCE;
    private Mgr02() {

    }
    public static Mgr02 getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (Mgr02.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Mgr02();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Mgr02 mgr01 = Mgr02.getINSTANCE();
        Mgr02 mgr02 = Mgr02.getINSTANCE();
        System.out.println(mgr01 == mgr02);
    }
}
