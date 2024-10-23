package com.example.weatherinfo;

import com.example.weatherinfo.model.WeatherInfo;
import com.example.weatherinfo.repository.WeatherInfoRepository;
import com.example.weatherinfo.service.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class WeatherServiceTest {

    @Autowired
    private WeatherService weatherService;

    @MockBean
    private WeatherInfoRepository weatherInfoRepository;

    @Test
    public void testGetWeatherInfo() {
        String pincode = "411014";
        LocalDate forDate = LocalDate.of(2020, 10, 15);

        WeatherInfo mockWeather = new WeatherInfo();
        mockWeather.setPincode(pincode);
        mockWeather.setLatitude(18.5204);
        mockWeather.setLongitude(73.8567);
        mockWeather.setForDate(forDate);
        mockWeather.setWeatherDescription("Clear sky");
        mockWeather.setTemperature(30.5);

        Mockito.when(weatherInfoRepository.findByPincodeAndForDate(pincode, forDate))
                .thenReturn(Optional.of(mockWeather));

        WeatherInfo weatherInfo = weatherService.getWeatherInfo(pincode, forDate);
        Assertions.assertNotNull(weatherInfo);
        Assertions.assertEquals("Clear sky", weatherInfo.getWeatherDescription());
    }
}
