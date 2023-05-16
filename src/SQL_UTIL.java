import java.sql.*;
public class SQL_UTIL {
    public static final String ACCOUNT_STRING = "jdbc:mysql://localhost:3306/routebepaling";
    static Connection connection;

    public static void initConnection(){
        if (connection != null){
            System.out.println("[WARNING] Connection has already been established");
        }
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(ACCOUNT_STRING, "root", "admin");
        }
//        catch(ClassNotFoundException | SQLException e){
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addUser(String username, String password){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users(username, pw) VALUES (?,?)");
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.execute();
            preparedStatement.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void addCity(City city){
        String n = city.getName();
        double lat = city.getLatitude();
        double lon = city.getLongitude();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cities(naam, latitude, longitude) VALUES (?,?,?)");
            preparedStatement.setString(1,n);
            preparedStatement.setDouble(2,lat);
            preparedStatement.setDouble(3,lon);
            preparedStatement.execute();
            preparedStatement.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
