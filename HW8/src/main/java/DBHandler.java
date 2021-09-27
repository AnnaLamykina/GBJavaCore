import org.sqlite.JDBC;

import java.sql.*;
import java.util.*;

public class DBHandler {

    private static final String CON_STR = "jdbc:sqlite:weather.sqlite";
    private static DBHandler instance = null;

    public static synchronized DBHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DBHandler();
        return instance;
    }

    private Connection connection;

    private DBHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
        createTable();
    }

    private void createTable(){
        String sql = "CREATE TABLE IF NOT EXISTS forecasts (\n"
                + "	city TEXT NOT NULL,\n"
                + "	date TEXT NOT NULL,\n"
                + "	weather TEXT NOT NULL,\n"
                + "	temperature DOUBLE NOT NULL\n"
                + ");";

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String[]> getAllWeatherForecastResponses() {
        ArrayList<String[]>  weathers = new ArrayList<String[]>();
        try (Statement statement = this.connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT city,date,temperature,weather FROM forecasts");
            while (resultSet.next()) {
                String[] arr = new String[4];
                arr[0] = resultSet.getString("city");
                arr[1] = resultSet.getString("date");
                arr[2] = resultSet.getString("weather");
                arr[3] = resultSet.getString("temperature");
                weathers.add(arr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return weathers;
    }

    public void Close() throws SQLException {
        connection.close();
    }

    public void addWeatherForecast(String city, String date, String weather, Double temperature) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO forecasts(`city`, `date`, `temperature`,`weather`) " +
                        "VALUES(?, ?, ?, ?)")) {
            statement.setObject(1, city);
            statement.setObject(2, date);
            statement.setObject(3, temperature);
            statement.setObject(4, weather);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}