import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Экземпляр класса OkHttpClient выполняет всю работу по созданию и отправке запросов
        OkHttpClient client = new OkHttpClient();

        // Экземпляр класса Request создается через Builder (см. паттерн проектирования "Строитель")
        Request request = new Request.Builder()
                .url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/295212?apikey=R7vQYEkopDocqyAeANyKIDxKIs0YeNFG")
                .build();

        // Получение объекта ответа от сервера
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
