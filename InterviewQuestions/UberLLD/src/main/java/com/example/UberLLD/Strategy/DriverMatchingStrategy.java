package com.example.UberLLD.Strategy;

import com.example.UberLLD.Model.Driver;
import com.example.UberLLD.Model.Location;

import java.util.List;

public interface DriverMatchingStrategy {

    Driver findDriver(
            Location pickup,
            List<Driver> drivers
    );
}
