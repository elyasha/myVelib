package core.components;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingSlotTest {

    @Test
    public void testToString() {
        ParkingSlot p = new ParkingSlot();
        int id = p.getId();
        int state = 0;
        String result = "ParkingSlot{" + "id=" + id + ", state=" + state + '}';

        assertEquals(result, p.toString());
    }

    @Test
    public void testEquals() {
        ParkingSlot p1 = new ParkingSlot();
        ParkingSlot p2 = new ParkingSlot();

        assertNotEquals(p1, p2);
    }

    @Test
    public void testHashCode() {
        ParkingSlot p1 = new ParkingSlot();
        ParkingSlot p2 = new ParkingSlot();

        assertNotEquals(p1.hashCode(), p2.hashCode());
    }
}