package degisn.state.test3;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description:
 * @date: 2022-04-23 20:22
 */
public class Car {
    CarState carState;

    public Car(CarState carState) {
        this.carState = carState;
    }

    public void open() {
        carState.open();
    }
    public void close() {
        carState.close();
    }
    public void run() {
        carState.run();
    }
    public void stop() {
        carState.stop();
    }
}
