package com.cbfacademy.DataBreachTracker;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class BreachService {

    private final BreachRepository breachRepository;

    public BreachService(BreachRepository breachRepository) {
        this.breachRepository = breachRepository;
    }

    public List<Breach> getAllBreaches() {
        return breachRepository.findAll();
    }

    public Breach getBreachById(Long id) {
        return breachRepository.findById(id)
                .orElseThrow(() -> new BreachNotFoundException(id));
    }

    public List<Breach> getBreachesByOrganisation(String organisation) {
        return breachRepository.findByOrganisation(organisation);
    }

    // 🔹 New filtering methods
    public List<Breach> getBreachesByOrganisationFilter(String organisation) {
        return breachRepository.findByOrganisationContainingIgnoreCase(organisation);
    }

    public List<Breach> getBreachesAfterDate(LocalDate date) {
        return breachRepository.findByDateAfter(date);
    }

    public Breach addBreach(Breach breach) {
        return breachRepository.save(breach);
    }

    public Breach updateBreach(Long id, Breach breach) {
        Breach existingBreach = breachRepository.findById(id)
                .orElseThrow(() -> new BreachNotFoundException(id));

        existingBreach.setOrganisation(breach.getOrganisation());
        existingBreach.setDate(breach.getDate());
        existingBreach.setDescription(breach.getDescription());
        existingBreach.setAffectedUsers(breach.getAffectedUsers());

        return breachRepository.save(existingBreach);
    }

    public void deleteBreach(Long id) {
        if (!breachRepository.existsById(id)) {
            throw new BreachNotFoundException(id);
        }
        breachRepository.deleteById(id);
    }
}
