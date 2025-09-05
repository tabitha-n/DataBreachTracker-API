package com.cbfacademy.DataBreachTracker;

public class BreachNotFoundException extends RuntimeException {// Custom exception for handling cases where a breach is not found
    // Constructor that takes a breach ID and constructs an error message
    public BreachNotFoundException(Long id) {
        super("Breach not found with id " + id);
    }
}

