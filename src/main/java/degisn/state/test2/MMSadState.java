package degisn.state.test2;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description:
 * @date: 2022-04-23 19:24
 */
public class MMSadState extends MMState{
    @Override
    void smile() {
        System.out.println("MM Sad Smile");
    }

    @Override
    void cry() {
        System.out.println("MM Sad Cry");
    }

    @Override
    void say() {
        System.out.println("MM Sad Say");
    }
}
