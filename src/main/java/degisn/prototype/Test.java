package degisn.prototype;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person p2 = (Person) p1.clone();
        System.out.println(p2.age+" "+p2.score);
        System.out.println(p2.loc);
        System.out.println(p1.loc == p2.loc);
        p1.loc.street = "sh";
        System.out.println(p2.loc);
    }
}
class Person implements Cloneable {
    int age = 8;
    int score = 100;
    Location loc = new Location("bj",22);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
