package com.cbfacademy.DataBreachTracker;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/breaches")

public class BreachController {

    private final BreachService breachService;

    public BreachController(BreachService breachService) {
        this.breachService = breachService;
    }

    @GetMapping
    public List<Breach> getAllBreaches() {
        return breachService.getAllBreaches();
    }

    @GetMapping("/{id}")
    public Breach getBreachById(@PathVariable Long id) {
        return breachService.getBreachById(id);
    }

    @GetMapping("/organisation/{organisation}")
    public List<Breach> getBreachesByOrganisation(@PathVariable String organisation) {
        return breachService.getBreachesByOrganisation(organisation);
    }

    // 🔹 New filter endpoint
    @GetMapping("/filter")
    public List<Breach> filterBreaches(
            @RequestParam(required = false) String organisation,
            @RequestParam(required = false) String date) {

        if (organisation != null) {
            return breachService.getBreachesByOrganisationFilter(organisation);
        } else if (date != null) {
            LocalDate parsedDate = LocalDate.parse(date);
            return breachService.getBreachesAfterDate(parsedDate);
        }
        return breachService.getAllBreaches(); // default if no filter
    }

    @PostMapping
    public Breach addBreach(@RequestBody Breach breach) {
        return breachService.addBreach(breach);
    }

    @PutMapping("/{id}")
    public Breach updateBreach(@PathVariable Long id, @RequestBody Breach breach) {
        return breachService.updateBreach(id, breach);
    }

    @DeleteMapping("/{id}")
    public void deleteBreach(@PathVariable Long id) {
        breachService.deleteBreach(id);
    }
}

