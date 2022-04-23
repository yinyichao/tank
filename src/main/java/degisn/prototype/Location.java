package degisn.prototype;

public class Location {
     String street;
     int num;
    public Location(String street, int num) {
        this.street = street;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", num=" + num +
                '}';
    }
}
