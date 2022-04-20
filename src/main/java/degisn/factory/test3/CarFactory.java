package degisn.factory.test3;

import degisn.factory.test1.Car;
/**
 * 简单工厂
 * 可扩展性不好
 */
public class CarFactory {
    public static Car generate() {
        return new Car();
    }
}
