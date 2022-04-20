package degisn.strategy.test3;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dog a[] = new Dog[]{new Dog(5),new Dog(3),new Dog(7)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
