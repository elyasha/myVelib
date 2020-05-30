package core.components.factories;

import core.components.*;
import core.system.MyVelibSystem;

public class BicycleFactory {

    public static void addElectricalBicycle(MyVelibSystem system, Station station) {

        // Check the station (parkingSlot available)
        ParkingSlot freeSlot = station.getOneFreeSlot();
        if (freeSlot != null) {
            // Creating the bicycle
            ElectricalBicycle bicycle = new ElectricalBicycle();

            // Add to station
            freeSlot.setState(1);
            freeSlot.setBicycle(bicycle);
        } else {
            System.out.println("There is no available slot!");
        }


    }

    public static Bicycle createElectricalBicycle() {
        return new ElectricalBicycle();
    }

    public static void addMechanicalBicycle(MyVelibSystem system, Station station) {
        // Check the station (parkingSlot available)
        ParkingSlot freeSlot = station.getOneFreeSlot();
        if (freeSlot != null) {
            // Creating the bicycle
            MechanicalBicycle bicycle = new MechanicalBicycle();

            // Add to station
            freeSlot.setState(1);
            freeSlot.setBicycle(bicycle);
        } else {
            System.out.println("There is no available slot!");
        }
    }

    public static Bicycle createMechanicalBicycle() {
        return new MechanicalBicycle();
    }
}
