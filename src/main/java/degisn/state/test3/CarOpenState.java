package degisn.state.test3;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description:
 * @date: 2022-04-23 20:25
 */
public class CarOpenState extends CarState{
    @Override
    public void open() {
        System.out.println("dont open");
    }

    @Override
    public void close() {
        System.out.println("car close");
    }

    @Override
    public void run() {
        System.out.println("dont run");
    }

    @Override
    public void stop() {
        System.out.println("dont stop");
    }
}
