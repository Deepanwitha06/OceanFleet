package com.oceanfleet.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VesselTest {

    // Verify the default constructor
    @Test
    void testDefaultConstructor() {
        Vessel vessel = new Vessel();

        assertNull(vessel.getVesselId());
        assertNull(vessel.getVesselName());
        assertEquals(0.0, vessel.getAverageSpeed());
        assertNull(vessel.getVesselType());
    }

    // Verify the parameterized constructor
    @Test
    void testParameterizedConstructor() {
        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        assertEquals("V001", vessel.getVesselId());
        assertEquals("Sea King", vessel.getVesselName());
        assertEquals(25.5, vessel.getAverageSpeed());
        assertEquals("Cargo", vessel.getVesselType());
    }

    // Verify setters and getters
    @Test
    void testGettersAndSetters() {
        Vessel vessel = new Vessel();

        vessel.setVesselId("V002");
        vessel.setVesselName("Ocean Star");
        vessel.setAverageSpeed(18.0);
        vessel.setVesselType("Tanker");

        assertEquals("V002", vessel.getVesselId());
        assertEquals("Ocean Star", vessel.getVesselName());
        assertEquals(18.0, vessel.getAverageSpeed());
        assertEquals("Tanker", vessel.getVesselType());
    }
}