package com.example.UberLLD.State;

import com.example.UberLLD.Model.Trip;


public class CompletedState implements TripState {

    @Override
    public void accept(Trip trip) {
        throw invalid();
    }

    @Override
    public void start(Trip trip) {
        throw invalid();
    }

    @Override
    public void complete(Trip trip) {
        throw invalid();
    }

    @Override
    public void cancel(Trip trip) {
        throw invalid();
    }

    private IllegalStateException invalid() {
        return new IllegalStateException(
                "Completed trip cannot be modified"
        );
    }
}