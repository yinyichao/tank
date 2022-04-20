package degisn.factory.test3;

import degisn.factory.test1.Moveable;

/**
 * 通过工厂模式[2]
 * 1、任意定制交通工具
 * 2、任意定制生产过程
 * 3、任意定制产品一族
 */
public class Main {
    public static void main(String[] args) {
        Moveable m = PlaneFactory.generate();
        m.go();
    }
}
