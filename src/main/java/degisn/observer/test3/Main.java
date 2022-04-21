package degisn.observer.test3;

public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        while(!child.isCry()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }
    }
}
