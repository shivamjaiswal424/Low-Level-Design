package com.example.UberLLD.Controller;


import com.example.UberLLD.Model.Location;
import com.example.UberLLD.Model.Rider;
import com.example.UberLLD.Model.Trip;
import com.example.UberLLD.Service.TripService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
public class TripController {

    private final TripService tripService;

    public TripController(
            TripService tripService
    ) {
        this.tripService = tripService;
    }

    @PostMapping
    public Trip createTrip(
            @RequestParam String riderId,
            @RequestParam String riderName,

            @RequestParam double pickupLat,
            @RequestParam double pickupLon,

            @RequestParam double destinationLat,
            @RequestParam double destinationLon
    ) {

        Rider rider =
                new Rider(
                        riderId,
                        riderName
                );

        Location pickup =
                new Location(
                        pickupLat,
                        pickupLon
                );

        Location destination =
                new Location(
                        destinationLat,
                        destinationLon
                );

        return tripService.createTrip(
                rider,
                pickup,
                destination
        );
    }

    @GetMapping("/{tripId}")
    public Trip getTrip(
            @PathVariable String tripId
    ) {

        return tripService.getTrip(tripId);
    }

    @PostMapping("/{tripId}/start")
    public Trip startTrip(
            @PathVariable String tripId
    ) {

        return tripService.startTrip(tripId);
    }

    @PostMapping("/{tripId}/complete")
    public Trip completeTrip(
            @PathVariable String tripId
    ) {

        return tripService.completeTrip(tripId);
    }

    @PostMapping("/{tripId}/cancel")
    public Trip cancelTrip(
            @PathVariable String tripId
    ) {

        return tripService.cancelTrip(tripId);
    }
}
