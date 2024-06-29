package weatherscheduler.scheduler;

import org.springframework.beans.factory.annotation.Value;
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

    @Scheduled(fixedRateString = "${scheduler.fixedRate}")
    public void scheduleWeatherDataFetch() {
        weatherService.fetchAndSaveWeatherData();
    }
}
