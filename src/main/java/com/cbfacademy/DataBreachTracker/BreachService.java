package com.cbfacademy.DataBreachTracker;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BreachService {

    // Attribute
    private final BreachRepository breachRepository;

    // Constructor - initializes the breachRepository attribute
    public BreachService(BreachRepository breachRepository) {
        this.breachRepository = breachRepository;
    }

    // Methods - perform operations on breach data

    //Retrieves a list of all breaches from the repository
    public List<Breach> getAllBreaches() {
        return breachRepository.findAll();
    }

    // Retrieves a specific breach by its ID, throwing an exception if not found
    public Breach getBreachById(Long id) {
        return breachRepository.findById(id)
                .orElseThrow(() -> new BreachNotFoundException(id));
    }

    // Retrieves breaches associated with a specific organisation
    public List<Breach> getBreachesByOrganisation(String organisation) {
        return breachRepository.findByOrganisation(organisation);
    }

    // Retrieves breaches where the organisation name contains a specific substring, ignoring case
    public List<Breach> getBreachesByOrganisationFilter(String organisation) {
        return breachRepository.findByOrganisationContainingIgnoreCase(organisation);
    }

    // Retrieves breaches that occurred after a specific date
    public List<Breach> getBreachesAfterDate(LocalDate date) {
        return breachRepository.findByDateAfter(date);
    }

    // Retrieves breaches that occurred before a specific date
    public Breach addBreach(Breach breach) {
        return breachRepository.save(breach);
    }

    // Updates an existing breach identified by its ID with new data
    public Breach updateBreach(Long id, Breach breach) {
        Breach existingBreach = breachRepository.findById(id)
                .orElseThrow(() -> new BreachNotFoundException(id));

        existingBreach.setOrganisation(breach.getOrganisation());
        existingBreach.setDate(breach.getDate());
        existingBreach.setIncidentType(breach.getIncidentType());
        existingBreach.setDataCompromised(breach.getDataCompromised());
        existingBreach.setAffectedUsers(breach.getAffectedUsers());

        return breachRepository.save(existingBreach);
    }

    // Deletes a breach identified by its ID
    public void deleteBreach(Long id) {
        if (!breachRepository.existsById(id)) {
            throw new BreachNotFoundException(id);
        }
        breachRepository.deleteById(id);
    }
}
