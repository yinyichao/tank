package degisn.factory.test1;

/**
 * 通过父类抽象[1]
 * 1、任意定制交通工具
 * 2、任意定制生产过程
 * 3、任意定制产品一族
 */
public class Main {
    public static void main(String[] args) {
        Moveable m = new Car();
        m.go();
    }
}
