package weatherscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weatherscheduler.entity.Forecast;
import weatherscheduler.xmlElement.*;

import java.time.LocalDate;

@Service
public class WeatherService {

    private static final String WEATHER_API_URL = "https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng";

    @Autowired
    private RestTemplate restTemplate;

    public void fetchAndSaveWeatherData() {
        ForecastsXml forecastsXml = restTemplate.getForObject(WEATHER_API_URL, ForecastsXml.class);
        ForecastXml forecastXml = forecastsXml.getForecast().get(0);

        Forecast forecast = new Forecast();
        forecast.setDate(LocalDate.parse(forecastXml.getDate()));
    }
}
