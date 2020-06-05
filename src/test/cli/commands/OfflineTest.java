package cli.commands;

import org.junit.Test;

import static cli.commands.Offline.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing OffLine Class
 */
public class OfflineTest {

    /**
     * Test that need to be implemented
     */
    @Test
    public void main() {
    }

    /**
     * Testing good input arguments
     */
    @Test
    public void hasGoodInput1() {
        //[velibnetworkName, stationID]
        String[] args = {"myVelib", "1"};
        assertTrue(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput2() {
        String[] args = {"myVelib", "stringArg"};
        assertFalse(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput3() {
        String[] args = {};
        assertFalse(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput4() {
        String[] args = {"myVelib", "1", "arg3"};
        assertFalse(hasGoodInput(args));
    }
}