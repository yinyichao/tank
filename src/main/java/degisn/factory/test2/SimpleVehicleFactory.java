package degisn.factory.test2;

import degisn.factory.test1.Car;
import degisn.factory.test1.Plane;

/**
 * 简单工厂
 * 可扩展性不好
 */
public class SimpleVehicleFactory {
    public static Car generateCar() {
        //before
        return new Car();
    }
    public static Plane generatePlane() {
        //before
        return new Plane();
    }
}
