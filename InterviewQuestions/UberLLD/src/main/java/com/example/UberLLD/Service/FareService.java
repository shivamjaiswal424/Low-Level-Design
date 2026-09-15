package com.example.UberLLD.Service;


import com.example.UberLLD.Model.Trip;
import com.example.UberLLD.Strategy.FareStrategy;
import org.springframework.stereotype.Service;

@Service
public class FareService {

    private final FareStrategy fareStrategy;

    public FareService(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public double calculateFare(Trip trip) {

        return fareStrategy.calculateFare(trip);
    }
}
