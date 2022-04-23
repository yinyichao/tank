package degisn.state.test1;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description: 增加新的状态时非常不方便
 * @date: 2022-04-23 19:16
 */
public class MM {
    String name;

    private enum MMState {HAPPY, SAD}

    MMState mmState;

    public void smile() {
        //switch case
    }

    public void cry() {
        //switch case
    }

    public void say() {
        //switch case
    }
}
