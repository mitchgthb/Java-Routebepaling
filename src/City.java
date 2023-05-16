public class City {
    private static final double EARTH_EQUATORIAL_RADIUS = 6378.1370D;
    private static final double CONVERT_DEGREES_TO_RADIUS = Math.PI/180D;
    private double latitude;
    private double longitude;
    private String name;
    public City(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude * CONVERT_DEGREES_TO_RADIUS;
        this.longitude = longitude * CONVERT_DEGREES_TO_RADIUS;
    }
    public double getLongitude() {return longitude;}
    public double getLatitude() {return latitude;}
    public String getName() {return name;}

    public double measureDistance(City city){
        double deltaLatitude = (city.getLatitude() - this.getLatitude());
        double deltaLongitude = (city.getLongitude() - this.getLongitude());
        double a = Math.pow(Math.sin(deltaLatitude / 2D), 2D) + Math.cos(this.getLatitude()) * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude / 2D), 2D);
        return EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(a), Math.sqrt(1D - a));
    }
//    public double measureDistanceTwo(City city){
//        double distance = Math.acos(Math.sin(this.latitude)*Math.sin(city.getLatitude()) +
//                Math.cos(this.latitude)*Math.cos(city.getLatitude())*Math.cos(city.getLatitude()-this.latitude))*EARTH_EQUATORIAL_RADIUS;
//        return distance;
//    }

    @Override
    public String toString() {return this.name;}
}
