package degisn.singleton;

/**
 * 不仅可以解决线程同步问题，还可以防止反序列化
 */
public enum Mgr04 {
    INSTANCE;

    public static void main(String[] args) {
        Mgr04 m1 = Mgr04.INSTANCE;
        Mgr04 m2 = Mgr04.INSTANCE;
        System.out.println(m1 == m2);
    }
}
