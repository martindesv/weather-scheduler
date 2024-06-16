package weatherscheduler.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import weatherscheduler.service.WeatherService;

@Component
@EnableScheduling
public class WeatherScheduler {

    private final WeatherService weatherService;

    public WeatherScheduler(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(fixedRate = 60000)
    public void scheduleWeatherDataFetch() {
        weatherService.fetchAndSaveWeatherData();
    }
}
