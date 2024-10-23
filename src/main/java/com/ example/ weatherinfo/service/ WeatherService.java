package com.example.weatherinfo.service;

import com.example.weatherinfo.model.WeatherInfo;
import com.example.weatherinfo.repository.WeatherInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    private WeatherInfoRepository weatherInfoRepository;

    @Autowired
    private RestTemplate restTemplate;

    private final String geocodingApiUrl = "https://maps.googleapis.com/maps/api/geocode/json";
    private final String openWeatherApiUrl = "https://api.openweathermap.org/data/2.5/weather";

    public WeatherInfo getWeatherInfo(String pincode, LocalDate forDate) {
        // Check if weather information is already stored in the DB
        Optional<WeatherInfo> cachedWeather = weatherInfoRepository.findByPincodeAndForDate(pincode, forDate);
        if (cachedWeather.isPresent()) {
            return cachedWeather.get();
        }

        // Fetch latitude and longitude for the given pincode using Geocoding API
        String latLongResponse = restTemplate.getForObject(geocodingApiUrl + "?address=" + pincode + "&key=YOUR_API_KEY", String.class);
        Double latitude = /* Extract latitude from response */;
        Double longitude = /* Extract longitude from response */;

        // Fetch weather data using OpenWeather API
        String weatherResponse = restTemplate.getForObject(openWeatherApiUrl + "?lat=" + latitude + "&lon=" + longitude + "&appid=YOUR_OPENWEATHER_API_KEY", String.class);
        String weatherDescription = /* Extract weather description */;
        Double temperature = /* Extract temperature */;

        // Save the weather info in DB
        WeatherInfo weatherInfo = new WeatherInfo();
        weatherInfo.setPincode(pincode);
        weatherInfo.setLatitude(latitude);
        weatherInfo.setLongitude(longitude);
        weatherInfo.setForDate(forDate);
        weatherInfo.setWeatherDescription(weatherDescription);
        weatherInfo.setTemperature(temperature);
        weatherInfoRepository.save(weatherInfo);

        return weatherInfo;
    }
}
