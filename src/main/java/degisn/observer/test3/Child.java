package degisn.observer.test3;
/**
 * 加入1个观察者
 */
public class Child {
    private boolean cry = false;
    Dad dad = new Dad();

    public boolean isCry() {
        return cry;
    }
    public void wakeUp(){
        System.out.println("Waked Up! Crying wuwuwu...");
        dad.feed();
    }
}
