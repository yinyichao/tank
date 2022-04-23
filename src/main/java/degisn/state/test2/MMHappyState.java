package degisn.state.test2;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description:
 * @date: 2022-04-23 19:23
 */
public class MMHappyState extends MMState{
    @Override
    void smile() {
        System.out.println("MM Happy Smile");
    }

    @Override
    void cry() {
        System.out.println("MM Happy Cry");
    }

    @Override
    void say() {
        System.out.println("MM Happy Say");
    }
}
