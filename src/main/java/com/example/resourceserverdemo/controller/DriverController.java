package com.example.resourceserverdemo.controller;

import com.example.resourceserverdemo.model.Driver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {

    /*
     Because we have configured this project with Spring Security and make it as a resource server,
     every api endpoint automatically expects valid JWT token; it knows whether it is valid or not
     by checking with the auth server ("issuer-uri")
     */

    // @PreAuthorize("hasRole('ADMIN')") or @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Driver>> getAll() {
        List<Driver> drivers = new ArrayList<>();

        Driver driver1 = new Driver(1, "Milos", "Radojcin", true);
        Driver driver2 = new Driver(2, "Stevan", "Bogdanovic", true);

        drivers.add(driver1);
        drivers.add(driver2);

        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

}
