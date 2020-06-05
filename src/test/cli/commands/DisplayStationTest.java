package cli.commands;

import org.junit.Test;

import static cli.commands.DisplayStation.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing DisplayStation Class
 */
public class DisplayStationTest {

    /**
     * Test that need to be implemented
     */
    @Test
    public void main() {
        //TODO
    }

    /**
     * Testing good input arguments
     */
    @Test
    public void hasGoodInputTest() {
        //[velibnetworkName, stationID]
        String[] args = {"myVelib", "1"};
        assertEquals(true, hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInputTest1() {
        //[velibnetworkName, stationID]
        String[] args = {"myVelib", "badID"};
        assertEquals(false, hasGoodInput(args));
    }
}