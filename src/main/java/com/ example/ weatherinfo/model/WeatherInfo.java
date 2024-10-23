package com.example.weatherinfo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "weather_info")
public class WeatherInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "for_date")
    private LocalDate forDate;

    @Column(name = "weather_description")
    private String weatherDescription;

    @Column(name = "temperature")
    private Double temperature;

    
}
