package com.cbfacademy.DataBreachTracker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreachServiceTest {

    @Autowired
    private BreachService breachService;

    private Breach testBreach;

    @BeforeEach
    void setUp() {
        // Create a new Breach object before each test
        testBreach = new Breach();
        testBreach.setOrganisation("Example Org");
        testBreach.setDate(LocalDateTime.now());
        testBreach.setDescription("Sample breach description");
        testBreach.setAffectedUsers(5000);
    }

    @Test
    void testAddBreach() {
        Breach savedBreach = breachService.addBreach(testBreach);

        assertNotNull(savedBreach.getId()); // ID should be generated
        assertEquals("Example Org", savedBreach.getOrganisation());
        assertEquals("Sample breach description", savedBreach.getDescription());
        assertEquals(5000, savedBreach.getAffectedUsers());
    }

    @Test
    void testGetAllBreaches() {
        breachService.addBreach(testBreach);
        List<Breach> allBreaches = breachService.getAllBreaches();

        assertFalse(allBreaches.isEmpty());
        assertTrue(allBreaches.stream()
                .anyMatch(b -> b.getOrganisation().equals("Example Org")));
    }

    @Test
    void testGetBreachById() {
        Breach savedBreach = breachService.addBreach(testBreach);
        Breach fetchedBreach = breachService.getBreachById(savedBreach.getId());

        assertEquals(savedBreach.getOrganisation(), fetchedBreach.getOrganisation());
        assertEquals(savedBreach.getDescription(), fetchedBreach.getDescription());
    }

    @Test
    void testUpdateBreach() {
        Breach savedBreach = breachService.addBreach(testBreach);

        savedBreach.setOrganisation("Updated Org");
        savedBreach.setAffectedUsers(10000);

        Breach updatedBreach = breachService.updateBreach(savedBreach.getId(), savedBreach);

        assertEquals("Updated Org", updatedBreach.getOrganisation());
        assertEquals(10000, updatedBreach.getAffectedUsers());
    }

    @Test
    void testDeleteBreach() {
        Breach savedBreach = breachService.addBreach(testBreach);

        breachService.deleteBreach(savedBreach.getId());

        assertThrows(BreachNotFoundException.class,
                () -> breachService.getBreachById(savedBreach.getId()));
    }
}


