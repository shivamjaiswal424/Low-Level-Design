package com.example.UberLLD.Repository;



import com.example.UberLLD.Model.Driver;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DriverRepository {

    private final Map<String, Driver> drivers = new ConcurrentHashMap<>();

    public Driver save(Driver driver) {

        drivers.put(driver.getId(), driver);

        return driver;
    }

    public Driver findById(String driverId) {

        return drivers.get(driverId);
    }

    public List<Driver> findAll() {

        return new ArrayList<>(drivers.values());
    }
}
