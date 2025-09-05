package com.cbfacademy.DataBreachTracker;

import org.springframework.web.bind.annotation.*;
import java.util.List;



// Both are annotations from Spring Boot
// They tell the application that this class handles HTTP requests related to the  "api/breaches" endpoint.
@RestController
@RequestMapping("api/breaches")

public class BreachController {

    // Attribute
    private final BreachService breachService;

    // Constructor - initializes the breachService attribute
    public BreachController(BreachService breachService) {
        this.breachService = breachService;
    }

    // Methods - handle HTTP requests
    @GetMapping // Handles GET requests to "api/breaches"
    public List<Breach> getAllBreaches() {
        return breachService.getAllBreaches();
    }

    @GetMapping("/{id}") // Handles GET requests to "api/breaches/{id}"
    public Breach getBreachById(@PathVariable Long id) {
        return breachService.getBreachById(id);
    }

    @GetMapping("/organisation/{organisation}") // Handles GET requests to "api/breaches/organisation/{organisation}"
    public List<Breach> getBreachesByOrganisation(@PathVariable String organisation) {
        return breachService.getBreachesByOrganisation(organisation);
    }

    @PostMapping // Handles POST requests to "api/breaches"
    public Breach addBreach(@RequestBody Breach breach) {
        return breachService.addBreach(breach);
    }

    @PutMapping("/{id}") // Handles PUT requests to "api/breaches/{id}"
    public Breach updateBreach(@PathVariable Long id, @RequestBody Breach breach) {
        return breachService.updateBreach(id, breach);
    }

    @DeleteMapping("/{id}") // Handles DELETE requests to "api/breaches/{id}"
    public void deleteBreach(@PathVariable Long id) {
        breachService.deleteBreach(id);
    }
}

// The controller interacts with the BreachService to perform operations on breach data.
// It defines endpoints for various operations like retrieving all breaches, retrieving a breach by ID, adding a new breach, updating an existing breach, and deleting a breach.

