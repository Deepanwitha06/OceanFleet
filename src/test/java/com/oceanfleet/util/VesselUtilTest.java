package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VesselUtilTest {

    private VesselUtil vesselUtil;

    @BeforeEach
    void setUp() {
        vesselUtil = new VesselUtil();
    }

    // Verify vessel storage
    @Test
    void testAddVesselPerformance() {
        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        vesselUtil.addVesselPerformance(vessel);

        assertEquals(1, vesselUtil.getVesselList().size());
    }

    // Verify successful vessel retrieval
    @Test
    void testGetVesselById() {
        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        vesselUtil.addVesselPerformance(vessel);

        assertEquals(vessel, vesselUtil.getVesselById("V001"));
    }

    // Verify missing vessel retrieval
    @Test
    void testVesselNotFound() {
        assertNull(vesselUtil.getVesselById("V999"));
    }

    // Verify highest-performing vessel selection
    @Test
    void testGetHighPerformanceVessels() {
        vesselUtil.addVesselPerformance(
                new Vessel("V001", "Sea King", 25.5, "Cargo")
        );
        vesselUtil.addVesselPerformance(
                new Vessel("V002", "Ocean Star", 18.0, "Tanker")
        );
        vesselUtil.addVesselPerformance(
                new Vessel("V003", "Wave Rider", 25.5, "Cruise")
        );

        List<Vessel> result = vesselUtil.getHighPerformanceVessels();

        assertEquals(2, result.size());
        assertEquals("V001", result.get(0).getVesselId());
        assertEquals("V003", result.get(1).getVesselId());
    }

    // Verify empty vessel collection
    @Test
    void testEmptyHighPerformanceList() {
        assertTrue(vesselUtil.getHighPerformanceVessels().isEmpty());
    }
}