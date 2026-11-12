package com.oceanfleet.ui;

import com.oceanfleet.model.Vessel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInterfaceTest {

    // Test parsing a valid vessel record
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

    // Test formatting vessel details
    @Test
    void testFormatVessel() {
        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        String result = UserInterface.formatVessel(vessel);

        assertEquals(
                "V001 | Sea King | Cargo | 25.5 knots",
                result
        );
    }

    // Test invalid record with missing fields
    @Test
    void testInvalidVesselRecord() {
        assertThrows(
                IllegalArgumentException.class,
                () -> UserInterface.parseVesselRecord("V001:Sea King:25.5")
        );
    }

    // Test invalid speed value
    @Test
    void testInvalidAverageSpeed() {
        assertThrows(
                NumberFormatException.class,
                () -> UserInterface.parseVesselRecord(
                        "V001:Sea King:fast:Cargo"
                )
        );
    }
}