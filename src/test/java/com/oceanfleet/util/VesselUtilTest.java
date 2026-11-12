
package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VesselUtilTest {

    // Test retrieval of an existing vessel
    @Test
    void testGetVesselById() {
        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        vesselUtil.addVesselPerformance(vessel);

        Vessel result = vesselUtil.getVesselById("V001");

        assertNotNull(result);
        assertSame(vessel, result);
        assertEquals("Sea King", result.getVesselName());
    }

    // Test retrieval when multiple vessels exist
    @Test
    void testGetVesselFromMultipleRecords() {
        VesselUtil vesselUtil = new VesselUtil();

        vesselUtil.addVesselPerformance(
                new Vessel("V001", "Sea King", 25.5, "Cargo")
        );

        vesselUtil.addVesselPerformance(
                new Vessel("V002", "Ocean Star", 18.0, "Tanker")
        );

        vesselUtil.addVesselPerformance(
                new Vessel("V003", "Wave Rider", 22.3, "Cruise")
        );

        Vessel result = vesselUtil.getVesselById("V002");

        assertNotNull(result);
        assertEquals("Ocean Star", result.getVesselName());
    }

    // Test an ID that does not exist
    @Test
    void testGetVesselByInvalidId() {
        VesselUtil vesselUtil = new VesselUtil();

        vesselUtil.addVesselPerformance(
                new Vessel("V001", "Sea King", 25.5, "Cargo")
        );

        assertNull(vesselUtil.getVesselById("V004"));
    }

    // Test case-sensitive ID comparison
    @Test
    void testGetVesselByCaseSensitiveId() {
        VesselUtil vesselUtil = new VesselUtil();

        vesselUtil.addVesselPerformance(
                new Vessel("V001", "Sea King", 25.5, "Cargo")
        );

        assertNull(vesselUtil.getVesselById("v001"));
    }

    // Test searching an empty list
    @Test
    void testGetVesselFromEmptyList() {
        VesselUtil vesselUtil = new VesselUtil();

        assertNull(vesselUtil.getVesselById("V001"));
    }
}
