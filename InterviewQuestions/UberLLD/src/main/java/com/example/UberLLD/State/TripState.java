package com.example.UberLLD.State;


import com.example.UberLLD.Model.Trip;

public interface TripState {

    void accept(Trip trip);

    void start(Trip trip);

    void complete(Trip trip);

    void cancel(Trip trip);
}
