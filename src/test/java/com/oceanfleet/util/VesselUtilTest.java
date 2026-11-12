package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VesselUtilTest {

    // Test when one vessel has the highest speed
    @Test
    void testSingleHighestPerformanceVessel() {
        VesselUtil util = new VesselUtil();

        util.addVesselPerformance(new Vessel("V001", "Sea King", 25.5, "Cargo"));
        util.addVesselPerformance(new Vessel("V002", "Ocean Star", 18.0, "Tanker"));
        util.addVesselPerformance(new Vessel("V003", "Wave Rider", 22.3, "Cruise"));

        List<Vessel> result = util.getHighPerformanceVessels();

        assertEquals(1, result.size());
        assertEquals("V001", result.get(0).getVesselId());
        assertEquals(25.5, result.get(0).getAverageSpeed());
    }

    // Test when multiple vessels share the highest speed
    @Test
    void testMultipleVesselsWithSameHighestSpeed() {
        VesselUtil util = new VesselUtil();

        util.addVesselPerformance(new Vessel("V001", "Sea King", 25.5, "Cargo"));
        util.addVesselPerformance(new Vessel("V002", "Ocean Star", 18.0, "Tanker"));
        util.addVesselPerformance(new Vessel("V003", "Wave Rider", 25.5, "Cruise"));

        List<Vessel> result = util.getHighPerformanceVessels();

        assertEquals(2, result.size());
        assertEquals("V001", result.get(0).getVesselId());
        assertEquals("V003", result.get(1).getVesselId());
    }

    // Test that vessels with lower speeds are excluded
    @Test
    void testLowerSpeedVesselsAreExcluded() {
        VesselUtil util = new VesselUtil();

        util.addVesselPerformance(new Vessel("V001", "Sea King", 25.5, "Cargo"));
        util.addVesselPerformance(new Vessel("V002", "Ocean Star", 18.0, "Tanker"));
        util.addVesselPerformance(new Vessel("V003", "Wave Rider", 22.3, "Cruise"));

        List<Vessel> result = util.getHighPerformanceVessels();

        assertFalse(result.stream().anyMatch(vessel ->
                vessel.getVesselId().equals("V002")));
        assertFalse(result.stream().anyMatch(vessel ->
                vessel.getVesselId().equals("V003")));
    }

    // Test when the vessel list is empty
    @Test
    void testEmptyVesselList() {
        VesselUtil util = new VesselUtil();

        List<Vessel> result = util.getHighPerformanceVessels();

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // Test when the list contains only one vessel
    @Test
    void testOnlyOneVessel() {
        VesselUtil util = new VesselUtil();

        util.addVesselPerformance(new Vessel("V001", "Sea King", 25.5, "Cargo"));

        List<Vessel> result = util.getHighPerformanceVessels();

        assertEquals(1, result.size());
        assertEquals("V001", result.get(0).getVesselId());
    }
}