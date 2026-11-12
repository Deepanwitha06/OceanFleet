package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;
import java.util.ArrayList;
import java.util.List;

public class VesselUtil {

    private List<Vessel> vesselList;

    // Initialize the vessel list
    public VesselUtil() {
        vesselList = new ArrayList<>();
    }

    // Add a vessel to the list
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Retrieve a vessel using its ID
    public Vessel getVesselById(String vesselId) {
        for (Vessel vessel : vesselList) {
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }
        return null;
    }

    // Return all vessels having the highest average speed
    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> highPerformanceVessels = new ArrayList<>();

        // Return an empty list when no vessels are available
        if (vesselList == null || vesselList.isEmpty()) {
            return highPerformanceVessels;
        }

        // First pass: find the maximum average speed
        double maxSpeed = vesselList.get(0).getAverageSpeed();

        for (Vessel vessel : vesselList) {
            if (vessel.getAverageSpeed() > maxSpeed) {
                maxSpeed = vessel.getAverageSpeed();
            }
        }

        // Second pass: collect every vessel having the maximum speed
        for (Vessel vessel : vesselList) {
            if (Double.compare(vessel.getAverageSpeed(), maxSpeed) == 0) {
                highPerformanceVessels.add(vessel);
            }
        }

        return highPerformanceVessels;
    }

    // Getter and setter for the vessel list
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }
}