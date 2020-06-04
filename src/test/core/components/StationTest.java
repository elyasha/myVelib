package core.components;

import core.components.factories.BicycleFactory;
import core.components.factories.ParkingSlotsFactory;
import core.components.factories.PointFactory;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.*;

public class StationTest {

    @Test
    public void getExistTypeBikeTest() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        assertTrue(station.getExistTypeBike(bicycle));
    }

    @Test
    public void hasAvailableElectricalBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        assertTrue(station.hasAvailableElectricalBicycle());
    }

    @Test
    public void hasAvailableMechanicalBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createMechanicalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        assertTrue(station.hasAvailableMechanicalBicycle());
    }

    @Test
    public void hasOneSlotFree() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createFreeParkingSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        assertTrue(station.hasOneSlotFree());
    }

    @Test
    public void getOneFreeSlot() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createFreeParkingSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        boolean hasOneSlotFree = false;
        if(station.getOneFreeSlot()!=null)
            hasOneSlotFree = true;
        assertTrue(hasOneSlotFree);
    }

    @Test
    public void getParkingSlotTypeBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createMechanicalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        boolean hasOneSlotFree = false;
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        if(station.getParkingSlotTypeBicycle(bicycle)!=null)
            hasOneSlotFree = true;
        assertTrue(hasOneSlotFree);
    }

    @Test
    public void getElectricalParkingSlot() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        boolean hasOneSlotFree = false;
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        if(station.getParkingSlotTypeBicycle(bicycle)!=null)
            hasOneSlotFree = true;
        assertTrue(hasOneSlotFree);
    }

    @Test
    public void getMechanicalParkingSlot() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        boolean hasOneSlotFree = false;
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        if(station.getParkingSlotTypeBicycle(bicycle)!=null)
            hasOneSlotFree = true;
        assertTrue(hasOneSlotFree);
    }

    @Test
    public void addMoney() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        station.addMoney(100);
        assertTrue(station.getMoney()== 200);
    }

    @Test
    public void removeMoney() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        station.removeMoney(100);
        assertTrue(station.getMoney()== 0);
    }

    @Test
    public void addNumberOfDroppings() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0,0),true,listPark,100,0);
        station.addNumberOfDroppings(100);
        assertTrue(station.getNumberOfDroppings()== 100);
    }
}