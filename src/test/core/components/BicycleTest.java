package core.components;

import core.components.factories.BicycleFactory;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Testing Bicycle Class
 */
public class BicycleTest {

    /**
     * Testing toString method
     */
    @org.junit.Test
    public void testToString() {
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        int id = bicycle.getId();
        String result = "Bicycle{" + "id=" + id + '}';
        assertEquals(result, bicycle.toString());
    }

    /**
     * Testing equals method
     */
    @org.junit.Test
    public void testEquals() {
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        Bicycle bicycle1 = BicycleFactory.createMechanicalBicycle();
        assertNotEquals(bicycle, bicycle1);
    }

    /**
     * Testing hashcode method
     */
    @org.junit.Test
    public void testHashCode() {
        Bicycle bicycle = BicycleFactory.createMechanicalBicycle();
        Bicycle bicycle1 = BicycleFactory.createMechanicalBicycle();
        assertNotEquals(bicycle1.hashCode(), bicycle.hashCode());
    }
}