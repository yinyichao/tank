package degisn.observer.test5;

public class Dad implements Observer{
    public void feed() {
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWeakUp() {
        feed();
    }
}
