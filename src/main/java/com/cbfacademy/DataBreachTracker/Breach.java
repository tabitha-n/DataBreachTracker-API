package com.cbfacademy.DataBreachTracker;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// JPA Entity representing a data breach
@Entity 
public class Breach {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID

    // Attributes
    private Long id; // Read-only, managed by JPA

    private String organisation; 
    private LocalDate date;
    private String incidentType;
    private String dataCompromised;
    private int affectedUsers;

    // No-arg constructor (required by JPA)
    public Breach() {}

    // Parameterized constructor (excluding ID)
    // Creates a new Breach object; provides values for all fields except ID
    public Breach(String organisation, LocalDate date, String incidentType, String dataCompromised, int affectedUsers) {
        this.organisation = organisation;
        this.date = date;
        this.incidentType = incidentType;
        this.dataCompromised = dataCompromised;
        this.affectedUsers = affectedUsers;
    }

    // Methods - Getters(to retrieve data) and Setters (to modify data)
    public Long getId() { return id; } // No setter


    public String getOrganisation() { return organisation; }
    public void setOrganisation(String organisation) { this.organisation = organisation; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getIncidentType() { return incidentType; }
    public void setIncidentType(String incidentType) { this.incidentType = incidentType; }

    public String getDataCompromised() { return dataCompromised; }
    public void setDataCompromised(String dataCompromised) { this.dataCompromised = dataCompromised; }

    public int getAffectedUsers() { return affectedUsers; }
    public void setAffectedUsers(int affectedUsers) { this.affectedUsers = affectedUsers; }
}

