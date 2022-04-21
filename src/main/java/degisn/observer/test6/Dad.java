package degisn.observer.test6;

public class Dad implements Observer {
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWeakUp(wakeUpEvent event) {
        feed();
    }
}
