import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weather {
    private static String apiKey;
    private static OkHttpClient client = new OkHttpClient();
    private static ObjectMapper objectMapper = new ObjectMapper();

    public Weather(String apiKey){
        this.apiKey=apiKey;
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private String GetBodyFromURL(String url) throws IOException {
        String delimiter = "?";
        if (url.contains("?")){delimiter="&";}
        Request request = new Request.Builder()
                .url(url+delimiter+"apikey="+ apiKey)
                .build();
        Response response = client.newCall(request).execute();
        String body=response.body().string();
        response.body().close();
        return body;
    }

    public String[] GetCurrentWeather(String city) throws IOException {
        String[] arr=new String[2];
        String wBody=GetBodyFromURL("http://dataservice.accuweather.com/currentconditions/v1/"+city);
        List<WeatherResponse> weatherResponses = objectMapper.readValue(wBody, new TypeReference<List<WeatherResponse>>(){});
        arr[0]=Float.toString(weatherResponses.get(0).getTemperature().getMetric().getValue());
        arr[1]=weatherResponses.get(0).getWeatherText();
        return arr;
    }

    public Map<String, String[]> GetWeatherFor5Cities(Map<String, String> cities) throws IOException {
        Map<String, String[]> weathers = new HashMap<>();
        int i=0;
        if (weathers.size()>5){
            System.out.println("More than 5 cities has been provided, show result maximum for 5");
        }
        for (Map.Entry entry : cities.entrySet()) {
            String[] arr=new String[3];
            WeatherForecastResponse weatherForecastResponse=GetWeather5(entry.getValue().toString());
            arr[0]=weatherForecastResponse.getDailyForecasts().get(i).getDate().toString();
            arr[1]=weatherForecastResponse.getDailyForecasts().get(i).getDay().getIconPhrase();
            arr[2]=Float.toString(weatherForecastResponse.getDailyForecasts().get(0).getTemperature().getMaximum().getValue());
            weathers.put(entry.getKey().toString(),arr);
            if (i==4){
                break;
            }
            i++;
        }
        return weathers;
    }

    private WeatherForecastResponse GetWeather5(String city) throws IOException {
        String wBody=GetBodyFromURL("http://dataservice.accuweather.com/forecasts/v1/daily/5day/"+city+"?language=ru-ru");
        return objectMapper.readValue(wBody, WeatherForecastResponse.class);
    }
}
