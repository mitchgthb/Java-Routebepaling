public class Main {
    public static void main(String[] args) {
        City a = new City("Boston", 42.3601, -71.0589);
        City b = new City("Houston", 29.7604, -95.3698);
        System.out.println(b.measureDistance(a));
//        System.out.println(b.measureDistanceTwo(a));

    }
}