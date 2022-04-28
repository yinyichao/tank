package degisn.state.test3;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description:
 * @date: 2022-04-23 20:23
 */
public abstract class CarState {
    public abstract void open();
    public abstract void close();
    public abstract void run();
    public abstract void stop();
}
