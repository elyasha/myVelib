package core.components;

import core.components.factories.ParkingSlotsFactory;
import core.components.factories.StationFactory;
import core.components.factories.UserFactory;
import core.system.MyVelibSystem;
import core.system.MyVelibSystemFactory;
import org.junit.Test;

import java.awt.*;
import java.util.List;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void seeMyStatus() {
        Manager manager = new Manager("Matheus", new Point(0,0), 0000, 56);
        assertEquals(manager.seeMyStatus(), manager.toString());
    }

    @Test
    public void seeCurrentStatus() {
        MyVelibSystem system = new MyVelibSystem();
        Manager user = UserFactory.addManager(system, "Matheus", new Point(0,0), 0000, 50);
        // TODO: Verify why this unit test passes when running alone but not when running with everything all together
        assertEquals(user.toString(), user.seeCurrentStatus(system, 1));

    }

    @Test
    public void seeCurrentStationState() {
        MyVelibSystem system = new MyVelibSystem();
        Manager user = UserFactory.addManager(system, "Matheus", new Point(0,0), 0000, 50);
        List<ParkingSlot> parkingSlots = ParkingSlotsFactory.createFreeParkingSlots(10);
        Station station = StationFactory.addPlusStation(system, new Point(0,0), true, parkingSlots);
        assertEquals(station.toString(), user.seeCurrentStationState(system, 1));
    }

    @Test
    public void displaySystemReport() {
        MyVelibSystem system = new MyVelibSystem();
        Manager user = UserFactory.addManager(system, "Matheus", new Point(0,0), 0000, 50);
        assertEquals(system.toString(), user.displaySystemReport(system));
    }
}