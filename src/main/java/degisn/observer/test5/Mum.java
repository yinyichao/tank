package degisn.observer.test5;

public class Mum implements Observer{
    public void hug() {
        System.out.println("mum huging...");
    }

    @Override
    public void actionOnWeakUp() {
        hug();
    }
}
