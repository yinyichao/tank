package degisn.observer.test5;

public class Dog implements Observer{
    public void wang() {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWeakUp() {
        wang();
    }
}
