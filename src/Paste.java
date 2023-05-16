import java.util.ArrayList;
import java.util.Arrays;

public class Paste {
    public class NearestNeighbor {
        public Route findShortestRoute(ArrayList<City> cities) {
            ArrayList<City> shortestRouteCities = new ArrayList<City>(cities.size());
            ArrayList<City> pendingCities = new ArrayList<City>(cities.size());
            ArrayList<City> citiesCopy = new ArrayList<City>(cities.size());
            citiesCopy.addAll(cities);
            ArrayList<City> shortestRouteBackCities = new ArrayList<City>(cities.size());
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Initial Route            ==> " + Arrays.toString(cities.toArray()));
            System.out.println("w/ total distance: "+ new Route(cities).calculateTotalDistance());
            System.out.println("---------------------------------------------------------------------------");

            City city = new City("Rotterdam", 51.926517, 4.462456);
            City startCity = new City("Rotterdam", 51.926517, 4.462456);
            City nextCity;
            updateRoutes(shortestRouteCities, cities, city);
            updateRoutes(pendingCities, citiesCopy, city);

            while (citiesCopy.size() >= 1) {
                city = getNextCity(cities, city);
                citiesCopy.remove(city);
                nextCity = getNextCity(citiesCopy, startCity);
                if(startCity.measureDistance(city) > startCity.measureDistance(nextCity)){
                    updateRoutes(shortestRouteBackCities, cities, nextCity);

                }else {
                    updateRoutes(shortestRouteCities, cities, city);
                }
            }
            int i = shortestRouteBackCities.size();
            while (i > 0) {
                nextCity = shortestRouteBackCities.get(i - 1);
                updateRoutes(shortestRouteCities, shortestRouteBackCities , nextCity);
                --i;
            }
            shortestRouteCities.add(startCity);
            return new Route(shortestRouteCities);
        }
        private void updateRoutes(ArrayList<City> shortestRouteCities, ArrayList<City> cities, City city) {
            shortestRouteCities.add(city);
            cities.remove(city);
//        System.out.println("Cities In Shortest Route ==> " + Arrays.toString(shortestRouteCities.toArray()));
//        System.out.println("Remaining Cities         ==> " + Arrays.toString(cities.toArray())+ "\n");
        }
        private City getNextCity(ArrayList<City> cities, City city) {
            return cities.stream().min((city1, city2) -> {
                int flag = 0;
                if (city1.measureDistance(city) < city2.measureDistance(city)) flag = -1;
                else if (city1.measureDistance(city) > city2.measureDistance(city)) flag = 1;
                return flag;
            }).get();
        }
    }
// bruteforce method
// calculate distance between each city

}
