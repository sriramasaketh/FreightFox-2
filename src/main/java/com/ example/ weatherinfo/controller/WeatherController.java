package com.example.weatherinfo.controller;

import com.example.weatherinfo.model.WeatherInfo;
import com.example.weatherinfo.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherInfo> getWeather(
            @RequestParam String pincode,
            @RequestParam String forDate) {

        LocalDate date = LocalDate.parse(forDate);
        WeatherInfo weatherInfo = weatherService.getWeatherInfo(pincode, date);
        return ResponseEntity.ok(weatherInfo);
    }
}
