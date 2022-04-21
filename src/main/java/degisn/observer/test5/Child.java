package degisn.observer.test5;

import java.util.ArrayList;
import java.util.List;

/**
 * 有很多时候，观察者需要根据事件的具体情况来进行处理
 * 大多数时候，我们处理事件的时候，需要事件源对象
 */
public class Child {
    private boolean cry = false;
    List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }
    public void wakeUp(){
        System.out.println("Waked Up! Crying wuwuwu...");
        for(Observer observer : observers) {
            observer.actionOnWeakUp();
        }
    }
}
