package core.components;

import core.components.factories.UserFactory;
import core.system.MyVelibSystem;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * Testing Manager Class
 */
public class ManagerTest {

    /**
     * Testing seeMyStatus method
     */
    @Test
    public void seeMyStatus() {
        Manager manager = new Manager("Matheus", new Point(0, 0), 0000, 56);
        assertEquals(manager.seeMyStatus(), manager.toString());
    }

    /**
     * Testing seeCurrentStatus method
     */
    @Test
    public void seeCurrentStatus() {
        MyVelibSystem system = new MyVelibSystem();
        Manager user = UserFactory.addManager(system, "Matheus", new Point(0, 0), 0000, 50);
        assertEquals(user.toString(), user.seeCurrentStatus(system, user.getId()));

    }

    /**
     * Testing displaySystemReport method
     */
    @Test
    public void displaySystemReport() {
        MyVelibSystem system = new MyVelibSystem();
        Manager user = UserFactory.addManager(system, "Matheus", new Point(0, 0), 0000, 50);
        assertEquals(system.toString(), user.displaySystemReport(system));
    }
}