package degisn.builder;

public class Main {
    public static void main(String[] args) {
        TerrainBuilder builder = new ComplexTerrainBuilder();
        //链式编程
        Terrain terrain = builder.buildWall().buildFort().buildMine().build();

        Person person = new Person.PersonBuilder().basicInfo(1,"a",22).basicLocation("s","1").build();
    }
}
