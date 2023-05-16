import java.util.ArrayList;
import java.util.Arrays;
import java.sql.*;

public class Driver {
    private ArrayList<City> initialCities = new ArrayList<City>(Arrays.asList(
            new City("Amersfoort", 52.155170, 5.387200),
            new City("Utrecht", 52.092876, 5.104480),
            new City("Rotterdam", 51.926517, 4.462456),
            new City("Den Haag", 52.078663, 4.288788),
            new City("Amsterdam", 52.377956, 4.897070),
            new City("Leiden", 52.160114, 4.497010),
            new City("Gouda", 52.01811935, 4.7111221346978),
            new City("Ede", 52.0401675, 5.6648594),
            new City("Dordrecht", 51.8132979,4.6900929)
//            new City("Rotterdam", 51.926517, 4.462456)
    ));
    public static void main(String[] args) {
        Driver driver = new Driver();
        ArrayList<City> cities = new ArrayList<City>();
        cities.addAll(driver.initialCities);
        driver.printShortestRoute(new NearestNeighbor().findShortestRoute(cities));
        City b = new City("Dordrecht", 51.8132979,4.6900929);

        SQL_UTIL.initConnection();
        SQL_UTIL.addCity(b);

    }

    public ArrayList<City> getInitialCities() {return initialCities;}
    public int findCity(String name) {
        for (City cc : initialCities) {
            String b = cc.getName();
            if(name.equals(b)) {
                return initialCities.indexOf(cc);
            }
        }
        return -1;
    }

    public void printShortestRoute(Route shortestRoute) {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Shortest route found so far: "+ shortestRoute);
        System.out.println("w/ total distance: "+ shortestRoute.calculateTotalDistance());
        System.out.println("---------------------------------------------------------------------------");
    }
}
