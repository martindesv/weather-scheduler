package weatherscheduler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import weatherscheduler.entity.Place;
import weatherscheduler.repository.PlaceRepository;
import weatherscheduler.xmlElement.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    @Value("${scheduler.url}")
    private String WEATHER_API_URL;

    private final RestTemplate restTemplate;

    private final PlaceRepository placeRepository;

    @Autowired
    public WeatherService(RestTemplate restTemplate, PlaceRepository placeRepository) {
        this.restTemplate = restTemplate;
        this.placeRepository = placeRepository;
    }

    @Transactional
    public void fetchAndSaveWeatherData() {
        ForecastsXml forecastsXml;
        try {
            System.out.println("Fetching weather data...");
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

        List<PlaceXml> mergedXmlPlaces = mergePlaceLists(nightDayPlaces);

        // Check if places already exist
        Optional<Place> existingPlaceOptional = placeRepository.findFirst();

        if (existingPlaceOptional.isPresent()) {
            placeRepository.deleteAll();
        }
        List<Place> newPlaces = createNewPlaces(forecastXml, mergedXmlPlaces);
        placeRepository.saveAll(newPlaces);
    }

    private static List<Place> createNewPlaces(ForecastXml forecastXml, List<PlaceXml> mergedPlaces) {
        List<Place> places = new ArrayList<>();
        for (PlaceXml mergedPlaceXml : mergedPlaces) {
            Place placeEntity = new Place();
            placeEntity.setName(mergedPlaceXml.getName());
            placeEntity.setTempmax(mergedPlaceXml.getTempmax());
            placeEntity.setTempmin(mergedPlaceXml.getTempmin());
            placeEntity.setPhenomenonDay(mergedPlaceXml.getPhenomenonDay());
            placeEntity.setPhenomenonNight(mergedPlaceXml.getPhenomenonNight());
            placeEntity.setDate(LocalDate.parse(forecastXml.getDate()));
            places.add(placeEntity);
        }

        return places;
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
