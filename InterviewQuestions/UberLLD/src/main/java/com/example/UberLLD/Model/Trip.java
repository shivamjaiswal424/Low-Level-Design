package com.example.UberLLD.Model;

import com.example.UberLLD.State.RequestedState;
import com.example.UberLLD.State.TripState;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Trip {

    private final String id;
    private final Rider rider;

    private final Location pickup;
    private final Location destination;

    private Driver driver;

    private TripState state;

    private Double fare;

    private final LocalDateTime createdAt;

    public Trip(
            String id,
            Rider rider,
            Location pickup,
            Location destination
    ) {
        this.id = id;
        this.rider = rider;
        this.pickup = pickup;
        this.destination = destination;

        // Initial state
        this.state = new RequestedState();

        this.createdAt = LocalDateTime.now();
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
    }

    // =========================
    // State transitions
    // =========================

    public void accept() {
        state.accept(this);
    }

    public void start() {
        state.start(this);
    }

    public void complete() {
        state.complete(this);
    }

    public void cancel() {
        state.cancel(this);
    }


}