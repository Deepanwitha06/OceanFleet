
package com.oceanfleet.util;

import com.oceanfleet.model.Vessel;
import java.util.ArrayList;
import java.util.List;

public class VesselUtil {

    // Stores all vessel performance records
    private List<Vessel> vesselList;

    // Initialize the vessel list
    public VesselUtil() {
        this.vesselList = new ArrayList<>();
    }

    // Add a vessel performance record
    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
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
