package com.example.UberLLD.State;

import com.example.UberLLD.Model.Trip;


public class InProgressState implements TripState {

    @Override
    public void accept(Trip trip) {

        throw new IllegalStateException(
                "Trip is already in progress"
        );
    }

    @Override
    public void start(Trip trip) {

        throw new IllegalStateException(
                "Trip is already in progress"
        );
    }

    @Override
    public void complete(Trip trip) {

        trip.setState(new CompletedState());
    }

    @Override
    public void cancel(Trip trip) {

        trip.setState(new CancelledState());
    }
}
