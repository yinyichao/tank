package degisn.strategy.test4;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Dog a[] = new Dog[]{new Dog(5),new Dog(3),new Dog(7)};
        Sorter<Dog> sorter = new Sorter();
        sorter.sort(a,new DogComparator());
        sorter.sort(a,(o1,o2)->{
            if(o1.food > o2.food) return 1;
            else if(o1.food < o2.food) return -1;
            return 0;
        });
        System.out.println(Arrays.toString(a));
    }
}
