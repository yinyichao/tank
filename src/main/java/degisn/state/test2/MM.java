package degisn.state.test2;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description: 增加新的状态时非常不方便
 * @date: 2022-04-23 19:16
 */
public class MM {
    MMState mmState;

    public MM(MMState mmState) {
        this.mmState = mmState;
    }

    public void smile() {
        mmState.smile();
    }

    public void cry() {
        mmState.cry();
    }

    public void say() {
        mmState.say();
    }
}
