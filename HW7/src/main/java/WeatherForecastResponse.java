import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class WeatherForecastResponse {

    @JsonProperty("DailyForecasts")
    private List<DailyForecast> dailyForecasts;
    public List<DailyForecast> getDailyForecasts() {
        return dailyForecasts;
    }

    public void setDailyForecasts(List<DailyForecast> dailyForecasts) {
        this.dailyForecasts = dailyForecasts;
    }
}

 class Maximum{
    @JsonProperty("Value")
    private int value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private int unitType;

    public Maximum(){}

     public int getValue() {
         return value;
     }

     public String getUnit() {
         return unit;
     }

     public int getUnitType() {
         return unitType;
     }

     public void setValue(int value) {
         this.value = value;
     }

     public void setUnit(String unit) {
         this.unit = unit;
     }

     public void setUnitType(int unitType) {
         this.unitType = unitType;
     }
}

 class TemperatureM{


     @JsonProperty("Maximum")
    private Maximum maximum;

    public TemperatureM(){}

     public Maximum getMaximum() {
         return maximum;
     }

     public void setMaximum(Maximum maximum) {
         this.maximum = maximum;
     }
}

 class Day{



     @JsonProperty("IconPhrase")
    private String iconPhrase;

    public Day(){}

     public String getIconPhrase() {
         return iconPhrase;
     }

     public void setIconPhrase(String iconPhrase) {
         this.iconPhrase = iconPhrase;
     }

}

 class DailyForecast{


    @JsonProperty("Date")
    private Date date;
    @JsonProperty("Temperature")
    private TemperatureM temperature;
    @JsonProperty("Day")
    private Day day;

    public DailyForecast(){}

     public Date getDate() {
         return date;
     }

     public TemperatureM getTemperature() {
         return temperature;
     }

     public Day getDay() {
         return day;
     }

     public void setDate(Date date) {
         this.date = date;
     }

     public void setTemperature(TemperatureM temperature) {
         this.temperature = temperature;
     }

     public void setDay(Day day) {
         this.day = day;
     }

}

