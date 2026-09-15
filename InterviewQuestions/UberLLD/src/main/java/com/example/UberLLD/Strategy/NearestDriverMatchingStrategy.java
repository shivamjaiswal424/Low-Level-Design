package com.example.UberLLD.Strategy;


import com.example.UberLLD.Model.Driver;
import com.example.UberLLD.Model.DriverStatus;
import com.example.UberLLD.Model.Location;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

@Component
public class NearestDriverMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public Driver findDriver(Location pickup, List<Driver> drivers) {

        return drivers.stream().filter(driver -> driver.getStatus() == DriverStatus.AVAILABLE).min(
                Comparator.comparingDouble(
                                driver ->
                                        driver.getLocation()
                                                .distanceTo(pickup)
                        )
                )
                .orElse(null);
    }
}