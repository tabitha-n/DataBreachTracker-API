package com.cbfacademy.DataBreachTracker;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface BreachRepository extends JpaRepository<Breach, Long> {
    List<Breach> findByOrganisation(String organisation);

    // New filtering methods
    List<Breach> findByOrganisationContainingIgnoreCase(String organisation);
    List<Breach> findByDateAfter(LocalDateTime date);
}


