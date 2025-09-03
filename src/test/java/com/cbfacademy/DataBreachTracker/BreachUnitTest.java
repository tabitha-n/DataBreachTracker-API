package com.cbfacademy.DataBreachTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class BreachUnitTest {
    
    @Test 
    public void testOrganisationGetterSetter() {
        Breach breach = new Breach();
        breach.setOrganisation("TestOrg");
        assertEquals("TestOrg", breach.getOrganisation());  
    }
    
    @Test
    public void testDateGetterSetter() {
        Breach breach = new Breach();
        LocalDate date = LocalDate.of(2023, 10, 1);
        breach.setDate(date);
        assertEquals(date, breach.getDate());
    }

    @Test
    public void testIncidentTypeGetterSetter() {
        Breach breach = new Breach();
        breach.setIncidentType("Hacking");
        assertEquals("Hacking", breach.getIncidentType());  
    }

    @Test
    public void testDataCompromisedGetterSetter() {
        Breach breach = new Breach();
        breach.setDataCompromised("Emails");
        assertEquals("Emails", breach.getDataCompromised());
    }

    @Test
    public void testAffectedUsersGetterSetter() {
        Breach breach = new Breach();
        breach.setAffectedUsers(1000);
        assertEquals(1000, breach.getAffectedUsers());  
    }
}
