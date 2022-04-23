package degisn.templateMethod;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description:
 * @date: 2022-04-23 19:06
 */
public class Main {
    public static void main(String[] args) {
        F f = new S();
        f.m();
    }
}
abstract class F {
    void m() {
        op1();
        op2();
    }

    abstract void op1();
    abstract void op2();
}
class S extends F {

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}
