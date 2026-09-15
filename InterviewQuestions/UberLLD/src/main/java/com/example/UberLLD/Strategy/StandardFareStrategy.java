package com.example.UberLLD.Strategy;


import com.example.UberLLD.Model.Trip;
import org.springframework.stereotype.Component;

@Component
public class StandardFareStrategy implements FareStrategy {

    private static final double BASE_FARE = 50;

    private static final double PER_KM = 15;


    @Override
    public double calculateFare(Trip trip) {
        double distance =
                trip.getPickup()
                        .distanceTo(trip.getDestination());

        return BASE_FARE + distance * PER_KM;
    }
}
