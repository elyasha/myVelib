package cli.commands;

import org.junit.Test;

import static cli.commands.Setup.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing SetupTest class
 */
public class SetupTest {

    /**
     * Test that need to be implemented
     */
    @Test
    public void main() {
    }

    /**
     * Testing has good input
     */
    @Test
    public void hasGoodInput1() {
        //[velibnetworkName]
        // [name, nstations, nslots, s, nbikes]

        String[] args = {"myVelib", "10", "10", "1200", "5"};
        assertTrue(hasGoodInput(args));
    }

    /**
     * Testing has good input
     */
    @Test
    public void hasGoodInput2() {
        //[velibnetworkName]
        // [name, nstations, nslots, s, nbikes]

        String[] args = {"myVelib", "10", "10", "1200", "15"};
        assertFalse(hasGoodInput(args));
    }

    /**
     * Testing has good input
     */
    @Test
    public void hasGoodInput3() {
        //[velibnetworkName]
        // [name, nstations, nslots, s, nbikes]

        String[] args = {"myVelib", "stringArg", "10", "1200", "5"};
        assertFalse(hasGoodInput(args));
    }


}