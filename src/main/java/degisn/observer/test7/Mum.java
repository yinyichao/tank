package degisn.observer.test7;

public class Mum implements Observer {
    public void hug() {
        System.out.println("mum huging...");
    }

    @Override
    public void actionOnWeakUp(wakeUpEvent event) {
        hug();
    }
}
