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
 * Testing Terminal Class
 */
public class TerminalTest {

    /**
     * Testing rentBicycle method
     */
    @Test
    public void rentBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        Terminal term = station.getStationTerminal();
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        term.rentBicycle(bicycle, user, systems.get(0).getStations().get(0));
        assertTrue(user.getBicycle() != null);
    }

    /**
     * Testing dropBicycle method
     */
    @Test
    public void dropBicycle() {
        List<ParkingSlot> listPark = ParkingSlotsFactory.createElectricalBicycleSlots(10);
        PlusStation station = new PlusStation(PointFactory.addPoint(0, 0), true, listPark, 100, 0);
        Terminal term = station.getStationTerminal();
        List<Station> stations = new ArrayList<Station>();
        stations.add(station);
        MyVelibSystemFactory.createMyVelibSystem(stations);
        List<MyVelibSystem> systems = new ArrayList<MyVelibSystem>();
        systems = CoreApp.getSystems();
        User user = UserFactory.addUser(systems.get(0), "Charlito", PointFactory.addPoint(0, 0), 999, 200);
        Bicycle bicycle = BicycleFactory.createElectricalBicycle();
        term.rentBicycle(bicycle, user, systems.get(0).getStations().get(0));
        term.dropBicycle(bicycle, user, systems.get(0).getStations().get(0));
        assertTrue(user.getBicycle() == null);
    }
}