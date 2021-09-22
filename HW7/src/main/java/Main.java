import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import static java.util.Map.entry;

public class Main {

    public static void main(String[] args) throws IOException {
        Weather weather=new Weather(getApiKey());
        String[] currentWeather = weather.GetCurrentWeather("295212");
        System.out.println("------------------PART 1------------------");
        System.out.println("WeatherText: "+currentWeather[0]+"\nTemperature: "+currentWeather[1]);
        System.out.println("------------------PART 2------------------");
        Map<String, String> cities = Map.ofEntries(
                entry("Санкт-Петербург", "295212"),
                entry("Москва", "294021"),
                entry("Пермь", "294922"),
                entry("Вологда", "296477"),
                entry("Владимир", "296263")
        );
        Map<String,String[]>weather5=weather.GetWeatherFor5Cities(cities);
        for (Map.Entry entry : weather5.entrySet()) {
            String[] arr=(String[])entry.getValue();
            System.out.println("В городе " + entry.getKey() + " на дату " +  arr[0] + " ожидается " + arr[1]+", температура - "+arr[2]);
        }
    }

    public static String getApiKey(){
        System.out.println("Пожалуйста, предоставьте ваш ключ для API dataservice.accuweather.com");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}





