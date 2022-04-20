package degisn.factory.test4;



/**
 * 通过抽象工厂[3]
 * 1、任意定制交通工具
 * 2、任意定制生产过程
 * 3、任意定制产品一族
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory = new ModernFactory();
        Vehicle m = factory.createVehicle();
        m.go();
        Weapon ak = factory.createWeapon();
        ak.shoot();
        Food bread = factory.createFood();
        bread.printName();
    }
}
