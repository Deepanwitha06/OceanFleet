package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;

import java.util.ArrayList;
import java.util.List;

// Utility class containing vessel storage and retrieval operations
public class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    // Adds a vessel to the list
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Finds a vessel using its ID
    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vesselId.equals(vessel.getVesselId())) {
                return vessel;
            }
        }
        return null;
    }

    // Returns all vessels having the maximum average speed
    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> highPerformanceVessels = new ArrayList<>();

        if (vesselList.isEmpty()) {
            return highPerformanceVessels;
        }

        double maxSpeed = vesselList.get(0).getAverageSpeed();

        // Find the maximum speed
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        // Collect all vessels with the maximum speed
        for (Vessel vessel : vesselList) {
            if (Double.compare(vessel.getAverageSpeed(), maxSpeed) == 0) {
                highPerformanceVessels.add(vessel);
            }
        }

        return highPerformanceVessels;
    }

    public List<Vessel> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }
}