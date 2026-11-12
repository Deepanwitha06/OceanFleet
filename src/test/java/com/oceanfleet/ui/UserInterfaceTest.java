package com.oceanfleet.ui;

import com.oceanfleet.model.Vessel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    // Verify conversion of input record into a Vessel object
    @Test
    void testParseVesselRecord() {
        Vessel vessel = UserInterface.parseVesselRecord(
                "V001:Sea King:25.5:Cargo"
        );

        assertEquals("V001", vessel.getVesselId());
        assertEquals("Sea King", vessel.getVesselName());
        assertEquals(25.5, vessel.getAverageSpeed());
        assertEquals("Cargo", vessel.getVesselType());
    }

    // Verify formatted vessel output
    @Test
    void testFormatVessel() {
        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        assertEquals(
                "V001 | Sea King | Cargo | 25.5 knots",
                UserInterface.formatVessel(vessel)
        );
    }

    // Verify invalid input handling
    @Test
    void testInvalidRecord() {
        assertThrows(
                IllegalArgumentException.class,
                () -> UserInterface.parseVesselRecord("V001:Sea King:25.5")
        );
    }
}