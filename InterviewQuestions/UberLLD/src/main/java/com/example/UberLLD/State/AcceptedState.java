package com.example.UberLLD.State;


import com.example.UberLLD.Model.Trip;

public class AcceptedState implements TripState {

    @Override
    public void accept(Trip trip) {

        throw new IllegalStateException(
                "Trip is already accepted"
        );
    }

    @Override
    public void start(Trip trip) {

        trip.setState(new InProgressState());
    }

    @Override
    public void complete(Trip trip) {

        throw new IllegalStateException(
                "Cannot complete an accepted trip"
        );
    }

    @Override
    public void cancel(Trip trip) {

        trip.setState(new CancelledState());
    }
}
