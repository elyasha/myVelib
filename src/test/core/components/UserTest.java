package core.components;

import core.CoreApp;
import core.components.factories.BicycleFactory;
import core.components.factories.ParkingSlotsFactory;
import core.components.factories.PointFactory;
import core.components.factories.UserFactory;
import core.system.MyVelibSystem;
import core.system.MyVelibSystemFactory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Testing the user class
 */
public class UserTest {

    /**
     * Testing the get name
     */
    @Test
    public void testGetName() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        assertTrue(user.getName() == "Charlito");
    }

    /**
     * Testing the equals method
     */
    @Test
    public void testEquals() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        User user2 = UserFactory.addUser(systems.get(0), "Matheus", PointFactory.addPoint(0, 0), 999, 200);
        assertFalse(user1.equals(user2));
    }

    /**
     * Testing the hashCode method
     */
    @Test
    public void testHashCode() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        User user2 = UserFactory.addUser(systems.get(0), "Matheus", PointFactory.addPoint(0, 0), 999, 200);
        assertTrue(user1.hashCode() != user2.hashCode());
    }

    /**
     * Testing the addCard method
     */
    @Test
    public void addCard() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        user1.addCard("Vmax");
        assertTrue(user1.getCard() != null);
    }

    /**
     * Testing the addMoney method
     */
    @Test
    public void addMoney() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        user1.addMoney(100);
        assertTrue(user1.getMoney() == 300);
    }

    /**
     * Testing the removeMoney method
     */
    @Test
    public void removeMoney() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        user1.removeMoney(100);
        assertTrue(user1.getMoney() == 100);
    }

    /**
     * Testing the addTimeCredit method
     */
    @Test
    public void addTimeCredit() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        user1.addTimeCredit(100);
        assertTrue(user1.getTimeCreditBalance() == 100);
    }

    /**
     * Testing the removeTimeCredit method
     */
    @Test
    public void removeTimeCredit() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        user1.addTimeCredit(100);
        user1.removeTimeCredit(50);
        assertTrue(user1.getTimeCreditBalance() == 50);
    }

    /**
     * Testing rentBicyclePlanning method
     */
    @Test
    public void rentBicyclePlanning() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        user1.rentBicyclePlanning(systems.get(0), PointFactory.addPoint(0, 0), PointFactory.addPoint(50, 50), bicycle);
        assertTrue(user1.getBicycle().getClass() == bicycle.getClass());
    }

    /**
     * Testing the dropBicyclePlanning
     */
    @Test
    public void dropBicyclePlanning() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        user1.rentBicyclePlanning(systems.get(0), PointFactory.addPoint(0, 0), PointFactory.addPoint(50, 50), bicycle);
        user1.dropBicyclePlanning(systems.get(0), PointFactory.addPoint(0, 0), PointFactory.addPoint(50, 50));
        assertTrue(user1.getBicycle() == null);
    }

    /**
     * Testing the addRenting method
     */
    @Test
    public void addRenting() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        int oldNumberRenting = user1.getNumberOfRentings();
        user1.addRenting();
        assertTrue(user1.getNumberOfRentings() == oldNumberRenting + 1);
    }

    /**
     * Testing the addSpentTimeOnElectricalBicycle method
     */
    @Test
    public void addSpentTimeOnElectricalBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        user1.addSpentTimeOnElectricalBicycle(100);
        user1.addSpentTimeOnElectricalBicycle(20);
        assertTrue(user1.getTimeSpentOnElectricalBicycle() == 120);
    }

    /**
     * Testing the addSpentTimeOnMechanicalBicycle method
     */
    @Test
    public void addSpentTimeOnMechanicalBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user1 = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        user1.addSpentTimeOnMechanicalBicycle(100);
        user1.addSpentTimeOnMechanicalBicycle(20);
        assertTrue(user1.getTimeSpentOnMechanicalBicycle() == 120);
    }
}