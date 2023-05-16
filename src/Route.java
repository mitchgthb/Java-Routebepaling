import java.util.ArrayList;
import java.util.Arrays;
public class Route {
    private ArrayList<City> cities = new ArrayList<City>();
    public Route(ArrayList<City> cities) { this.cities.addAll(cities); }
    public ArrayList<City> getCities() { return cities; }
    public int calculateTotalDistance() {
        int citiesSize = this.getCities().size();
        return (int) (this.getCities().stream().mapToDouble(x -> {
            int cityIndex = this.getCities().indexOf(x);
            double returnValue = 0;
            if (cityIndex < citiesSize - 1) returnValue = x.measureDistance(this.getCities().get(cityIndex + 1));
            return returnValue;
        }).sum() + this.getCities().get(citiesSize - 1).measureDistance(this.getCities().get(0)));
    }
    public String toString() { return Arrays.toString(cities.toArray()); }
}
