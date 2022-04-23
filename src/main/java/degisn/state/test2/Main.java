package degisn.state.test2;

/**
 * @version: java version 1.8
 * @Author: yins
 * @description:
 * @date: 2022-04-23 19:24
 */
public class Main {
    public static void main(String[] args) {
        MM mm = new MM(new MMHappyState());
        mm.smile();
    }
}
