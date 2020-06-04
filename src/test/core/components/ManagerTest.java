package core.components;

import core.components.factories.UserFactory;
import core.system.MyVelibSystem;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class ManagerTest {

    @Test
    public void seeMyStatus() {
        Manager manager = new Manager("Matheus", new Point(0, 0), 0000, 56);
        assertEquals(manager.seeMyStatus(), manager.toString());
    }

    @Test
    public void seeCurrentStatus() {
        MyVelibSystem system = new MyVelibSystem();
        Manager user = UserFactory.addManager(system, "Matheus", new Point(0, 0), 0000, 50);
        assertEquals(user.toString(), user.seeCurrentStatus(system, user.getId()));

    }

    @Test
    public void displaySystemReport() {
        MyVelibSystem system = new MyVelibSystem();
        Manager user = UserFactory.addManager(system, "Matheus", new Point(0, 0), 0000, 50);
        assertEquals(system.toString(), user.displaySystemReport(system));
    }
}