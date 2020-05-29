package core.components.factories;

import core.components.ElectricalBicycle;
import core.components.MechanicalBicycle;
import core.components.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSlotsFactory {

    public static List<ParkingSlot> createFreeParkingSlots(int numberOfParkingSlots) {

        List<ParkingSlot> slots = new ArrayList<ParkingSlot>();
        for (int i = 0; i < numberOfParkingSlots; i++) {
            slots.add(new ParkingSlot());
        }

        return slots;

    }

    public static ParkingSlot createFreeParkingSlot() {

        ParkingSlot parkingSlot = new ParkingSlot();

        return parkingSlot;
    }

    public static ParkingSlot createElectricalBicycleSlot() {
        return new ParkingSlot(1, new ElectricalBicycle());
    }

    public static List<ParkingSlot> createElectricalBicycleSlots(int numberOfBicycles) {
        List<ParkingSlot> slots = new ArrayList<ParkingSlot>();

        for (int i = 0; i < numberOfBicycles; i++) {
            ElectricalBicycle bicycle = new ElectricalBicycle();
            ParkingSlot slot = new ParkingSlot(1, bicycle);
            slots.add(slot);
        }

        return slots;
    }

    public static ParkingSlot createMechanicalBicycleSlot() {
        return new ParkingSlot(1, new MechanicalBicycle());
    }

    public static List<ParkingSlot> createMechanicalBicycleSlots(int numberOfBicycles) {
        List<ParkingSlot> slots = new ArrayList<ParkingSlot>();

        for (int i = 0; i < numberOfBicycles; i++) {
            MechanicalBicycle bicycle = new MechanicalBicycle();
            ParkingSlot slot = new ParkingSlot(1, bicycle);
            slots.add(slot);
        }

        return slots;
    }
}
