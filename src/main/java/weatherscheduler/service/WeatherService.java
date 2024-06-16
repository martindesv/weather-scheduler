package weatherscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weatherscheduler.entity.*;
import weatherscheduler.repository.ForecastRepository;
import weatherscheduler.repository.PlaceRepository;

@Service
public class WeatherService {

    private static final String WEATHER_API_URL = "https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ForecastRepository forecastRepository;

    @Autowired
    private PlaceRepository placeRepository;

    public void fetchAndSaveWeatherData() {
        Forecasts forecasts = restTemplate.getForObject(WEATHER_API_URL, Forecasts.class);
    }
}
