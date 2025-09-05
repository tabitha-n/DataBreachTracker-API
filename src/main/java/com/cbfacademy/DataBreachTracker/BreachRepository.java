package com.cbfacademy.DataBreachTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface BreachRepository extends JpaRepository<Breach, Long> {

    // Custom query method to find breaches by organisation name
    List<Breach> findByOrganisation(String organisation);

    // Custom query method to find breaches where organisation name contains a substring (case-insensitive)
    List<Breach> findByOrganisationContainingIgnoreCase(String organisation); // Case-insensitive search
    List<Breach> findByDateAfter(LocalDate date); // Find breaches after a specific date
}

// The BreachRepository interface extends JpaRepository, providing CRUD operations for the Breach entity.
// It also includes custom query methods to find breaches by organisation name, filter by organisation name (case-insensitive), and find breaches that occurred after a specific date.
