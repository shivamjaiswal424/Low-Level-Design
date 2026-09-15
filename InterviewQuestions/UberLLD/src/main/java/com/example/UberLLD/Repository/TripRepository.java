package com.example.UberLLD.Repository;



import com.example.UberLLD.Model.Trip;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TripRepository {

    private final Map<String, Trip> trips = new ConcurrentHashMap<>();

    public Trip save(Trip trip) {

        trips.put(trip.getId(), trip);

        return trip;
    }

    public Trip findById(String tripId) {

        return trips.get(tripId);
    }
}
