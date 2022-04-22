package degisn.builder;

public class Person {
    int id;
    String name;
    int age;
    double weight;
    int score;
    Location loc;
    private Person() {
    }
    public static class PersonBuilder {
        Person p = new Person();
        public PersonBuilder basicInfo(int id, String name, int age) {
            p.id = id;
            p.name = name;
            p.age = age;
            return this;
        }
        public PersonBuilder basicWeight(double weight) {
            p.weight = weight;
            return this;
        }
        public PersonBuilder basicLocation(String street,String roomNo) {
            Location loc = new Location(street,roomNo);
            p.loc = loc;
            return this;
        }
        public Person build() {
            return p;
        }
    }
}
class Location {
    String street;
    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
