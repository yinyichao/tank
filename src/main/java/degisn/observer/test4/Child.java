package degisn.observer.test4;

/**
 * 加入多个观察者
 */
public class Child {
    private boolean cry = false;
    Dad dad = new Dad();
    Mum mum = new Mum();
    Dog dog = new Dog();

    public boolean isCry() {
        return cry;
    }
    public void wakeUp(){
        System.out.println("Waked Up! Crying wuwuwu...");
        dad.feed();
        mum.hug();
        dog.wang();
    }
}
