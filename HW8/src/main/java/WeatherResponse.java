import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse {
    @JsonProperty("WeatherText")
    private String weatherText;
    @JsonProperty("Temperature")
    private Temperature temperatureObject;

    public WeatherResponse () {}

    public Temperature getTemperature() {return temperatureObject;}
    public void setTemperature(Temperature temperatureObject) {this.temperatureObject = temperatureObject;}
    public String getWeatherText() {return weatherText;}
    public void setWeatherText(String WeatherText) {this.weatherText = WeatherText;}
}

class Temperature {
    @JsonProperty("Metric")
    private Metric MetricObject;

    public Temperature(){}

    public Metric getMetric() {return MetricObject;}
    public void setMetric(Metric metricObject) {this.MetricObject = metricObject;}

}

class Metric {
    @JsonProperty("Value")
    private float value;

    public Metric(){}

    public float getValue() {return value;}
    public void setValue(float Value) {this.value = Value;}
}