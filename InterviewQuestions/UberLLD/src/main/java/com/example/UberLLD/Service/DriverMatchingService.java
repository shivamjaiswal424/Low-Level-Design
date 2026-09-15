package com.example.UberLLD.Service;


import com.example.UberLLD.Model.Driver;
import com.example.UberLLD.Model.Location;
import com.example.UberLLD.Repository.DriverRepository;
import com.example.UberLLD.Strategy.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

@Service
public class DriverMatchingService {

    private final DriverRepository driverRepository;

    private final DriverMatchingStrategy matchingStrategy;

    public DriverMatchingService(DriverRepository driverRepository, DriverMatchingStrategy matchingStrategy
    ) {
        this.driverRepository = driverRepository;
        this.matchingStrategy = matchingStrategy;
    }

    public Driver findDriver(Location pickup) {

        return matchingStrategy.findDriver(
                pickup,
                driverRepository.findAll()
        );
    }
}
