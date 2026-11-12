package com.oceanfleet.ui;

import com.oceanfleet.model.Vessel;
import com.oceanfleet.util.VesselUtil;

import java.util.List;
import java.util.Scanner;

// UI class responsible only for input and output
public class UserInterface {

    // Converts user input into a Vessel object
    public static Vessel parseVesselRecord(String record) {

        String[] details = record.split(":", -1);

        if (details.length != 4) {
            throw new IllegalArgumentException("Invalid vessel record");
        }

        return new Vessel(
                details[0].trim(),
                details[1].trim(),
                Double.parseDouble(details[2].trim()),
                details[3].trim()
        );
    }

    // Formats vessel information for display
    public static String formatVessel(Vessel vessel) {
        return vessel.getVesselId() + " | "
                + vessel.getVesselName() + " | "
                + vessel.getVesselType() + " | "
                + vessel.getAverageSpeed() + " knots";
    }

    // Main method controls the console application
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        VesselUtil vesselUtil = new VesselUtil();

        System.out.println("Enter number of vessels:");
        int count = Integer.parseInt(scanner.nextLine().trim());

        // Collect vessel records
        for (int i = 0; i < count; i++) {
            System.out.println(
                    "Enter vessel details (vesselId:vesselName:averageSpeed:vesselType):"
            );

            String record = scanner.nextLine();
            Vessel vessel = parseVesselRecord(record);

            vesselUtil.addVesselPerformance(vessel);
        }

        // Retrieve vessel using its ID
        System.out.println("Enter vessel ID to search:");
        String searchId = scanner.nextLine().trim();

        Vessel foundVessel = vesselUtil.getVesselById(searchId);

        if (foundVessel != null) {
            System.out.println(formatVessel(foundVessel));
        } else {
            System.out.println("Vessel Id " + searchId + " not found.");
        }

        // Display the highest-performing vessels
        System.out.println("High performance vessels are");

        List<Vessel> highPerformanceVessels =
                vesselUtil.getHighPerformanceVessels();

        for (Vessel vessel : highPerformanceVessels) {
            System.out.println(formatVessel(vessel));
        }

        scanner.close();
    }
}