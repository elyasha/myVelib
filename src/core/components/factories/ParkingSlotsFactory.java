package core.components.factories;

import core.components.ElectricalBicycle;
import core.components.MechanicalBicycle;
import core.components.ParkingSlot;

import java.util.ArrayList;
import java.util.List;

/**
 * The ParkingSlotFactory class : This is the factory to create and add new parking slots to stations
 * It is uses the simple factory design pattern
 */
public class ParkingSlotsFactory {

    /**
     * This methods creates free parking slots (as a list) and return the new instances
     *
     * @param numberOfParkingSlots the quantity of parking slots that we need
     * @return a list of free parking slots
     */
    public static List<ParkingSlot> createFreeParkingSlots(int numberOfParkingSlots) {

        List<ParkingSlot> slots = new ArrayList<>();
        for (int i = 0; i < numberOfParkingSlots; i++) {
            slots.add(new ParkingSlot());
        }

        return slots;

    }

    /**
     * This methods create a free parking slot and return the new instance
     *
     * @return a free parking slot instance
     */
    public static ParkingSlot createFreeParkingSlot() {

        return new ParkingSlot();
    }

    /**
     * This methods creates an electrical bicycle parking slot and return the new instance
     *
     * @return an electrical bicycle slot instance
     */
    public static ParkingSlot createElectricalBicycleSlot() {
        return new ParkingSlot(1, new ElectricalBicycle());
    }

    /**
     * This methods creates electrical parking slots (as a list) and return the new instances
     *
     * @param numberOfBicycles the quantity of parking slots that we need
     * @return a list of electrical parking slots
     */
    public static List<ParkingSlot> createElectricalBicycleSlots(int numberOfBicycles) {
        List<ParkingSlot> slots = new ArrayList<>();

        for (int i = 0; i < numberOfBicycles; i++) {
            ElectricalBicycle bicycle = new ElectricalBicycle();
            ParkingSlot slot = new ParkingSlot(1, bicycle);
            slots.add(slot);
        }

        return slots;
    }

    /**
     * This methods creates a mechanical bicycle parking slot and return the new instance
     *
     * @return an electrical bicycle slot instance
     */
    public static ParkingSlot createMechanicalBicycleSlot() {
        return new ParkingSlot(1, new MechanicalBicycle());
    }

    /**
     * This methods creates mechanical parking slots (as a list) and return the new instances
     *
     * @param numberOfBicycles the quantity of parking slots that we need
     * @return a list of mechanical parking slots
     */
    public static List<ParkingSlot> createMechanicalBicycleSlots(int numberOfBicycles) {
        List<ParkingSlot> slots = new ArrayList<>();

        for (int i = 0; i < numberOfBicycles; i++) {
            MechanicalBicycle bicycle = new MechanicalBicycle();
            ParkingSlot slot = new ParkingSlot(1, bicycle);
            slots.add(slot);
        }

        return slots;
    }
}
