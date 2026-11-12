
package com.oceanfleet.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VesselTest {

    // Test the no-argument constructor
    @Test
    void testNoArgumentConstructor() {
        Vessel vessel = new Vessel();

        assertNull(vessel.getVesselId());
        assertNull(vessel.getVesselName());
        assertEquals(0.0, vessel.getAverageSpeed());
        assertNull(vessel.getVesselType());
    }

    // Test the parameterized constructor
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

    // Test setter and getter methods
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
