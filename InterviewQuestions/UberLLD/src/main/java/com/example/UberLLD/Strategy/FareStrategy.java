package com.example.UberLLD.Strategy;


import com.example.UberLLD.Model.Trip;

public interface FareStrategy {

    double calculateFare(Trip trip);
}
