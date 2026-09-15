package com.example.UberLLD.State;


import com.example.UberLLD.Model.Trip;

public class RequestedState implements TripState {

    @Override
    public void accept(Trip trip) {

        trip.setState(new AcceptedState());
    }

    @Override
    public void start(Trip trip) {

        throw new IllegalStateException(
                "Cannot start a requested trip"
        );
    }

    @Override
    public void complete(Trip trip) {

        throw new IllegalStateException(
                "Cannot complete a requested trip"
        );
    }

    @Override
    public void cancel(Trip trip) {

        trip.setState(new CancelledState());
    }
}
