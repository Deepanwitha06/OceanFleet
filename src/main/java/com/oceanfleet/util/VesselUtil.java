package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;

import java.util.ArrayList;
import java.util.List;

// Utility class responsible for vessel-related business logic
public class VesselUtil {

    private List<Vessel> vesselList = new ArrayList<>();

    // Stores a vessel record
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Retrieves a vessel using its ID
    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vesselId.equals(vessel.getVesselId())) {
                return vessel;
            }
        }
        return null;
    }

    // Identifies all vessels having the maximum average speed
    public List<Vessel> getHighPerformanceVessels() {

        List<Vessel> highPerformanceVessels = new ArrayList<>();

        if (vesselList.isEmpty()) {
            return highPerformanceVessels;
        }

        double maxSpeed = vesselList.get(0).getAverageSpeed();

        // Determine the highest average speed
        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        // Include all vessels tied at the highest speed
        for (Vessel vessel : vesselList) {
            if (Double.compare(vessel.getAverageSpeed(), maxSpeed) == 0) {
                highPerformanceVessels.add(vessel);
            }
        }

        return highPerformanceVessels;
    }

    // Provides access to the vessel collection
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }
}