package com.example.UberLLD.Controller;


import com.example.UberLLD.Model.Driver;
import com.example.UberLLD.Model.Location;
import com.example.UberLLD.Repository.DriverRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverRepository driverRepository;

    public DriverController(
            DriverRepository driverRepository
    ) {
        this.driverRepository = driverRepository;
    }

    @PostMapping
    public Driver createDriver(

            @RequestParam String id,

            @RequestParam String name,

            @RequestParam double latitude,

            @RequestParam double longitude
    ) {

        Driver driver =
                new Driver(
                        id,
                        name,
                        new Location(
                                latitude,
                                longitude
                        )
                );

        return driverRepository.save(driver);
    }

    @PostMapping("/{id}/location")
    public Driver updateLocation(

            @PathVariable String id,

            @RequestParam double latitude,

            @RequestParam double longitude
    ) {

        Driver driver =
                driverRepository.findById(id);

        if (driver == null) {

            throw new RuntimeException(
                    "Driver not found"
            );
        }

        driver.updateLocation(
                new Location(
                        latitude,
                        longitude
                )
        );

        return driverRepository.save(driver);
    }
}
