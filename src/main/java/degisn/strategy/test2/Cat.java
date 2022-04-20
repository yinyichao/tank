package degisn.strategy.test2;

public class Cat {
    private int weight;
    private int height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    public int compareTo(Cat c) {
        if(weight > c.weight) {
            return 1;
        }else if(weight < c.weight) {
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
