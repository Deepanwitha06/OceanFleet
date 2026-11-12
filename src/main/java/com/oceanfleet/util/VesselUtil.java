
package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;

import java.util.ArrayList;
import java.util.List;

public class VesselUtil {

    // Stores vessel performance records
    private List<Vessel> vesselList;

    // Initialize the list
    public VesselUtil() {
        this.vesselList = new ArrayList<>();
    }

    // Add a vessel to the list
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    // Search for a vessel using its ID
    public Vessel getVesselById(String vesselId) {

        // Traverse the vessel list
        for (Vessel vessel : vesselList) {

            // Compare IDs using case-sensitive equality
            if (vessel.getVesselId().equals(vesselId)) {
                return vessel;
            }
        }

        // Return null if no matching vessel is found
        return null;
    }

    // Getter for vesselList
    public List<Vessel> getVesselList() {
        return vesselList;
    }

    // Setter for vesselList
    public void setVesselList(List<Vessel> vesselList) {
        this.vesselList = vesselList;
    }
}
