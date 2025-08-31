package com.cbfacademy.DataBreachTracker;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Breach {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Read-only, managed by JPA

    private String organisation;
    private LocalDate date;
    private String description;
    private int affectedUsers;

    public Breach() {}

    public Breach(String organisation, LocalDate date, String description, int affectedUsers) {
        this.organisation = organisation;
        this.date = date;
        this.description = description;
        this.affectedUsers = affectedUsers;
    }

    public Long getId() { return id; } // No setter

    public String getOrganisation() { return organisation; }
    public void setOrganisation(String organisation) { this.organisation = organisation; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getAffectedUsers() { return affectedUsers; }
    public void setAffectedUsers(int affectedUsers) { this.affectedUsers = affectedUsers; }
}

