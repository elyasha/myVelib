package cli.commands;

import org.junit.Test;

import static cli.commands.SortStation.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing SortStation Class
 */
public class SortStationTest {

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
        //[velibnetworkName, sortpolicy]
        String[] args = {"myVelib", "policy"};
        assertTrue(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput2() {
        //[velibnetworkName, sortpolicy]
        String[] args = {"myVelib"};
        assertTrue(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput3() {
        //[velibnetworkName, sortpolicy]
        String[] args = {"myVelib", "policy", "arg3"};
        assertFalse(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput4() {
        //[velibnetworkName, sortpolicy]
        String[] args = {"test", "1"};
        assertFalse(hasGoodInput(args));
    }
}