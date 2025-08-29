package com.cbfacademy.DataBreachTracker;

public class BreachNotFoundException extends RuntimeException {
    public BreachNotFoundException(Long id) {
        super("Breach not found with id " + id);
    }
}

