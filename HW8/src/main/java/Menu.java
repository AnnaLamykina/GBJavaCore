import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;

public class Menu {
    private static Weather weather;
    private static DBHandler dbHandler;
    private static Scanner scanner;

    public Menu() throws SQLException {
        this.scanner= new Scanner(System.in);
        this.weather = new Weather(getApiKey());
        this.dbHandler = DBHandler.getInstance();
    }

    public void Start() throws IOException {
        Choice();
    }

    public int Choice() throws IOException {
        while (true) {
            System.out.println("\n-----------Menu-----------\n" +
                    "Пожалуйста выберите один из пунктов(ввести только цифру)\n" +
                    "1) Вывести погоду в Санкт-Петербурге с accuweather\n" +
                    "2) Вывести погоду в Санкт-Петербург,Москва,Пермь,Вологда,Владимир с accuweather\n" +
                    "3) Вывести погоду в Санкт-Петербург,Москва,Пермь,Вологда,Владимир из локально сохранной базы данных\n" +
                    "4) Выход");
            String choice=scanner.nextLine();
            int choiceInt=0;
            try {
                choiceInt=Integer.parseInt(choice);
            }         catch (NumberFormatException ex) {
                System.out.println("\nТОЛЬКО ЧИСЛО ОТ 1-4\n");
                continue;
            }
            switch (choiceInt) {
                case  (1):
                    Choice1();
                    break;
                case (2):
                    Choice2();
                    break;
                case (3):
                    Choice3();
                    break;
                case (4):
                    Choice4();
                    break;
                default:
                    System.out.println("\nпожалуйста выберите 1-4\n");
                    break;
            }
        }
    }

    public void Choice1() throws IOException {
        System.out.println("\n-----------погода в Санкт-Петербурге-----------\n");
        String[] currentWeather = weather.GetCurrentWeather("295212");
        System.out.println("WeatherText: "+currentWeather[0]+"\nTemperature: "+currentWeather[1]);
    }

    public void Choice2() {
        System.out.println("\n-----------погода в Санкт-Петербург,Москва,Пермь,Вологда,Владимир с accuweather-----------\n");
        Map<String, String> cities = Map.ofEntries(
                entry("Санкт-Петербург", "295212"),
                entry("Москва", "294021"),
                entry("Пермь", "294922"),
                entry("Вологда", "296477"),
                entry("Владимир", "296263")
        );
        try {
            Map<String,String[]>weather5 = weather.GetWeatherFor5Cities(cities);
            for (Map.Entry entry : weather5.entrySet()) {
                String[] arr=(String[])entry.getValue();
                System.out.println("В городе " + entry.getKey() + " на дату " +  arr[0] + " ожидается " + arr[1]+", температура - "+arr[2]);
                dbHandler.addWeatherForecast(entry.getKey().toString(),arr[0],arr[1], new Double(arr[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Choice3() throws IOException {
        System.out.println("\n-----------погода в Санкт-Петербург,Москва,Пермь,Вологда,Владимир из локально сохранной базы данных-----------\n");
        ArrayList<String[]> weathers=dbHandler.getAllWeatherForecastResponses();
        for (String[] w:weathers) {
            System.out.println("В городе " + w[0] + " на дату " +  w[1] + " ожидается " + w[2]+", температура - "+w[3]);
        }

    }

    public void Choice4(){
        try {
            dbHandler.Close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.exit(1);
        }
        System.exit(0);
    }

    public static String getApiKey(){
        System.out.println("Пожалуйста, предоставьте ваш ключ для API dataservice.accuweather.com");
        return scanner.nextLine();
    }
}
