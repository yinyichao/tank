package degisn.strategy.test2;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cat a[] = new Cat[]{new Cat(5,5),new Cat(3,3),new Cat(7,7)};
        Sorter sorter = new Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
