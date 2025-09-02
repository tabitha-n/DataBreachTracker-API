package com.cbfacademy.DataBreachTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class BreachTest {

    @Test
    public void testBreachGettersAndSetters() {
        Breach breach = new Breach();
        breach.setOrganisation("TestOrg");
        breach.setDate(LocalDate.of(2023, 1, 1));
        breach.setIncidentType("Hacking");
        breach.setDataCompromised("Emails");
        breach.setAffectedUsers(1000);

        assertEquals("TestOrg", breach.getOrganisation());
        assertEquals(LocalDate.of(2023, 1, 1), breach.getDate());
        assertEquals("Hacking", breach.getIncidentType());
        assertEquals("Emails", breach.getDataCompromised());
        assertEquals(1000, breach.getAffectedUsers());  
    }
    
}
