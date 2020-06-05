package core.components;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testing ParkingSlot Class
 */
public class ParkingSlotTest {

    /**
     * Testing tostring method
     */
    @Test
    public void testToString() {
        ParkingSlot p = new ParkingSlot();
        int id = p.getId();
        int state = 0;
        String result = "ParkingSlot{" + "id=" + id + ", state=" + state + '}';

        assertEquals(result, p.toString());
    }

    /**
     * Testing Equals method
     */
    @Test
    public void testEquals() {
        ParkingSlot p1 = new ParkingSlot();
        ParkingSlot p2 = new ParkingSlot();

        assertNotEquals(p1, p2);
    }

    /**
     * Testing Hashcode method
     */
    @Test
    public void testHashCode() {
        ParkingSlot p1 = new ParkingSlot();
        ParkingSlot p2 = new ParkingSlot();

        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
}