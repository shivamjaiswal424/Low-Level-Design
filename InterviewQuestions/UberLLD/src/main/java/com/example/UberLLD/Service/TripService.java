package com.example.UberLLD.Service;

import com.example.UberLLD.Model.*;
import com.example.UberLLD.Repository.DriverRepository;
import com.example.UberLLD.Repository.TripRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TripService {

    private final TripRepository tripRepository;
    private final DriverRepository driverRepository;
    private final DriverMatchingService driverMatchingService;
    private final FareService fareService;
    private final PaymentService paymentService;

    public TripService(
            TripRepository tripRepository,
            DriverRepository driverRepository,
            DriverMatchingService driverMatchingService,
            FareService fareService,
            PaymentService paymentService
    ) {
        this.tripRepository = tripRepository;
        this.driverRepository = driverRepository;
        this.driverMatchingService = driverMatchingService;
        this.fareService = fareService;
        this.paymentService = paymentService;
    }

    /**
     * Rider requests a new trip.
     *
     * Flow:
     * REQUESTED
     *      |
     *      v
     * Find available driver
     *      |
     *      v
     * ACCEPTED
     */
    public Trip createTrip(
            Rider rider,
            Location pickup,
            Location destination
    ) {

        // 1. Create trip in REQUESTED state
        Trip trip = new Trip(
                UUID.randomUUID().toString(),
                rider,
                pickup,
                destination
        );

        tripRepository.save(trip);

        // 2. Find nearest available driver
        Driver driver =
                driverMatchingService.findDriver(pickup);

        if (driver == null) {
            throw new IllegalStateException(
                    "No driver available"
            );
        }

        // 3. Assign driver
        trip.assignDriver(driver);

        // 4. Mark driver as BUSY
        driver.setStatus(DriverStatus.BUSY);

        // 5. Transition REQUESTED -> ACCEPTED
        trip.accept();

        // 6. Persist changes
        driverRepository.save(driver);
        tripRepository.save(trip);

        return trip;
    }


    /**
     * Start an accepted trip.
     *
     * ACCEPTED -> IN_PROGRESS
     */
    public Trip startTrip(String tripId) {

        Trip trip = getTrip(tripId);

        // State object validates whether this transition is legal.
        trip.start();

        return tripRepository.save(trip);
    }


    /**
     * Complete a trip.
     *
     * IN_PROGRESS -> COMPLETED
     *
     * Before completing:
     * 1. Calculate fare
     * 2. Process payment
     * 3. Complete trip
     * 4. Release driver
     */
    public Trip completeTrip(String tripId) {

        Trip trip = getTrip(tripId);

        // Calculate fare
        double fare =
                fareService.calculateFare(trip);

        trip.setFare(fare);

        // Idempotency key for payment
        String idempotencyKey =
                trip.getId() + "-PAYMENT";

        // Process payment
        Payment payment =
                paymentService.processPayment(
                        trip.getId(),
                        fare,
                        idempotencyKey
                );

        // Payment must succeed before completing trip
        if (payment.getStatus()
                != PaymentStatus.SUCCESS) {

            throw new IllegalStateException(
                    "Payment failed. Trip cannot be completed."
            );
        }

        // State Pattern:
        // IN_PROGRESS -> COMPLETED
        trip.complete();

        // Make driver available again
        Driver driver = trip.getDriver();

        if (driver != null) {

            driver.setStatus(
                    DriverStatus.AVAILABLE
            );

            driverRepository.save(driver);
        }

        return tripRepository.save(trip);
    }


    /**
     * Cancel a trip.
     *
     * The TripState determines whether cancellation
     * is allowed from the current state.
     */
    public Trip cancelTrip(String tripId) {

        Trip trip = getTrip(tripId);

        // State Pattern handles whether cancellation
        // is valid from the current state.
        trip.cancel();

        // Release driver if one was assigned
        Driver driver = trip.getDriver();

        if (driver != null) {

            driver.setStatus(
                    DriverStatus.AVAILABLE
            );

            driverRepository.save(driver);
        }

        return tripRepository.save(trip);
    }


    /**
     * Retrieve trip.
     */
    public Trip getTrip(String tripId) {

        Trip trip =
                tripRepository.findById(tripId);

        if (trip == null) {

            throw new IllegalStateException(
                    "Trip not found: " + tripId
            );
        }

        return trip;
    }
}