package degisn.factory.test3;

import degisn.factory.test1.Plane;
/**
 * 工厂模式
 *
 */
public class PlaneFactory {
    public static Plane generate() {
        return new Plane();
    }
}
