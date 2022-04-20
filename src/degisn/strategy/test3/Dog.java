package degisn.strategy.test3;

public class Dog implements Comparable {
    private int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Object o) {
        Dog d = (Dog) o;
        if(this.food > d.food) {
            return 1;
        }else if(this.food == d.food) {
            return 0;
        }else{
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
