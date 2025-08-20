package com.cbfacademy.DataBreachTracker;

// This is the main application class for the Data Breach Tracker application.
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity // Indicates that this class is a JPA entity
@Table(name = "breaches")                                   // Maps this entity to the "breaches" table in the database
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)       // Uses single table inheritance strategy
@DiscriminatorColumn(name = "breach_type")                  // Specifies the column used to differentiate between different types of breaches

// This class represents a data breach entity in the application.
public class Breach {
    @Id                                                     // Specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Automatically generates the primary key value
    private Long id;                    // Unique identifier for the breach

    private String companyName;         // Name of the company affected by the breach
    private LocalDateTime breachDate;   // Date when the breach occurred
    private String dataLost;            // Description of the data lost in the breach
    private String description;         // Additional description of the breach
    private int recordsAffected;        // Number of records affected by the breach

    // Constructors
    public Breach() {
    }

    public Breach(String companyName, LocalDateTime breachDate, String dataLost, String description, int recordsAffected) {
        this.companyName = companyName;
        this.breachDate = breachDate;
        this.dataLost = dataLost;
        this.description = description;
        this.recordsAffected = recordsAffected;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDateTime getBreachDate() {
        return breachDate;
    }
    public void setBreachDate(LocalDateTime breachDate) {
        this.breachDate = breachDate;
    }

    public String getDataLost() {
        return dataLost;
    }
    public void setDataLost(String dataLost) {
        this.dataLost = dataLost;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description; 
    }

    public int getRecordsAffected() {
        return recordsAffected;
    }
    public void setRecordsAffected(int recordsAffected) {
        this.recordsAffected = recordsAffected;
    }
    
}
