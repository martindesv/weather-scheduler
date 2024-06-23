package weatherscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import weatherscheduler.entity.Forecast;
import weatherscheduler.entity.Place;
import weatherscheduler.xmlElement.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import weatherscheduler.repository.ForecastRepository;

@Service
public class WeatherService {

    private static final String WEATHER_API_URL = "https://www.ilmateenistus.ee/ilma_andmed/xml/forecast.php?lang=eng";

    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private ForecastRepository forecastRepository;

    public void fetchAndSaveWeatherData() {
        ForecastsXml forecastsXml;
        try {
            forecastsXml = restTemplate.getForObject(WEATHER_API_URL, ForecastsXml.class);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        ForecastXml forecastXml = forecastsXml.getForecast().get(0);

        List<PlaceXml> dayPlaces = forecastXml.getDay().getPlace();
        List<PlaceXml> nightPlaces = forecastXml.getNight().getPlace();

        List<PlaceXml> nightDayPlaces = new ArrayList<>();
        nightDayPlaces.addAll(dayPlaces);
        nightDayPlaces.addAll(nightPlaces);

        List<PlaceXml> mergedPlaces = mergePlaceLists(nightDayPlaces);

        Forecast forecast = getForecast(forecastXml, mergedPlaces);
        forecastRepository.save(forecast);
    }

    private static Forecast getForecast(ForecastXml forecastXml, List<PlaceXml> mergedPlaces) {
        Forecast forecast = new Forecast();
        forecast.setDate(LocalDate.parse(forecastXml.getDate()));

        List<Place> places = new ArrayList<>();
        for (PlaceXml mergedPlaceXml : mergedPlaces) {
            Place placeEntity = new Place();
            placeEntity.setName(mergedPlaceXml.getName());
            placeEntity.setTempmax(mergedPlaceXml.getTempmax());
            placeEntity.setTempmin(mergedPlaceXml.getTempmin());
            placeEntity.setPhenomenonDay(mergedPlaceXml.getPhenomenonDay());
            placeEntity.setPhenomenonNight(mergedPlaceXml.getPhenomenonNight());
            placeEntity.setForecast(forecast);
            places.add(placeEntity);
        }


        forecast.setPlace(places);
        return forecast;
    }

    public static List<PlaceXml> mergePlaceLists(List<PlaceXml> places) {
        // We can merge Night Place and Day Place into one object
        return new ArrayList<>(places.stream()
                .collect(Collectors.toMap(
                        PlaceXml::getName,
                        place -> place,
                        (place1, place2) -> {
                            place1.merge(place2);
                            return place1;
                        }
                ))
                .values());
    }
}
