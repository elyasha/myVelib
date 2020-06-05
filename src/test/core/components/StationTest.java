package core.components;

import core.components.factories.BicycleFactory;
import core.components.factories.ParkingSlotsFactory;
import core.components.factories.PointFactory;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Testing Station Class
 */
public class StationTest {

    /**
     * Testing getExistTypeBike method
     */
    @Test
    public void getExistTypeBikeTest() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        assertTrue(station.getExistTypeBike(bicycle));
    }

    /**
     * Testing hasAvailableElectricalBicycle method
     */
    @Test
    public void hasAvailableElectricalBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        assertTrue(station.hasAvailableElectricalBicycle());
    }

    /**
     * Testing hasAvailableMechanicalBicycle method
     */
    @Test
    public void hasAvailableMechanicalBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createMechanicalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        assertTrue(station.hasAvailableMechanicalBicycle());
    }

    /**
     * Testing hasOneSlotFree method
     */
    @Test
    public void hasOneSlotFree() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createFreeParkingSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        assertTrue(station.hasOneSlotFree());
    }

    /**
     * Testing getOneFreeSlot method
     */
    @Test
    public void getOneFreeSlot() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createFreeParkingSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        boolean hasOneSlotFree = false;
        if (station.getOneFreeSlot() != null)
            hasOneSlotFree = true;
        assertTrue(hasOneSlotFree);
    }

    /**
     * Testing getParkingSlotTypeBicycle method
     */
    @Test
    public void getParkingSlotTypeBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createMechanicalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        boolean hasOneSlotFree = false;
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        if (station.getParkingSlotTypeBicycle(bicycle) != null)
            hasOneSlotFree = true;
        assertTrue(hasOneSlotFree);
    }

    /**
     * Testing getElectricalParkingSlot method
     */
    @Test
    public void getElectricalParkingSlot() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        boolean hasOneSlotFree = false;
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        if (station.getParkingSlotTypeBicycle(bicycle) != null)
            hasOneSlotFree = true;
        assertTrue(hasOneSlotFree);
    }

    /**
     * Testing getMechanicalParkingSlot method
     */
    @Test
    public void getMechanicalParkingSlot() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        boolean hasOneSlotFree = false;
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        if (station.getParkingSlotTypeBicycle(bicycle) != null)
            hasOneSlotFree = true;
        assertTrue(hasOneSlotFree);
    }

    /**
     * Testing addMoney method
     */
    @Test
    public void addMoney() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        station.addMoney(100);
        assertTrue(station.getMoney() == 200);
    }

    /**
     * Testing removeMoney method
     */
    @Test
    public void removeMoney() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        station.removeMoney(100);
        assertTrue(station.getMoney() == 0);
    }

    /**
     * Testing addNumberOfDroppings method
     */
    @Test
    public void addNumberOfDroppings() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        station.addNumberOfDroppings(100);
        assertTrue(station.getNumberOfDroppings() == 100);
    }
}