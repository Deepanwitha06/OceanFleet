
package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VesselUtilTest {

    // Verify that the vessel list is initialized
    @Test
    void testVesselListInitialization() {
        VesselUtil vesselUtil = new VesselUtil();

        assertNotNull(vesselUtil.getVesselList());
        assertTrue(vesselUtil.getVesselList().isEmpty());
    }

    // Verify that a vessel can be added
    @Test
    void testAddVesselPerformance() {
        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        vesselUtil.addVesselPerformance(vessel);

        assertEquals(1, vesselUtil.getVesselList().size());
        assertSame(vessel, vesselUtil.getVesselList().get(0));
    }

    // Verify that multiple vessels can be added
    @Test
    void testAddMultipleVessels() {
        VesselUtil vesselUtil = new VesselUtil();

        Vessel vessel1 = new Vessel(
                "V001", "Sea King", 25.5, "Cargo"
        );

        Vessel vessel2 = new Vessel(
                "V002", "Ocean Star", 18.0, "Tanker"
        );

        vesselUtil.addVesselPerformance(vessel1);
        vesselUtil.addVesselPerformance(vessel2);

        assertEquals(2, vesselUtil.getVesselList().size());
        assertSame(vessel1, vesselUtil.getVesselList().get(0));
        assertSame(vessel2, vesselUtil.getVesselList().get(1));
    }

    // Verify that the vessel list can be replaced
    @Test
    void testSetVesselList() {
        VesselUtil vesselUtil = new VesselUtil();

        List<Vessel> vessels = new ArrayList<>();
        vessels.add(new Vessel(
                "V003", "Wave Rider", 22.3, "Cruise"
        ));

        vesselUtil.setVesselList(vessels);

        assertSame(vessels, vesselUtil.getVesselList());
        assertEquals(1, vesselUtil.getVesselList().size());
    }
}
