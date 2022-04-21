package degisn.observer.test6;

public class Dog implements Observer {
    public void wang() {
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWeakUp(wakeUpEvent event) {
        wang();
    }
}
