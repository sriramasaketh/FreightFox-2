package com.example.weatherinfo.repository;

import com.example.weatherinfo.model.WeatherInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface WeatherInfoRepository extends JpaRepository<WeatherInfo, Long> {

    Optional<WeatherInfo> findByPincodeAndForDate(String pincode, LocalDate forDate);
}
