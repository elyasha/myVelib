package cli.commands;

import org.junit.Test;

import static cli.commands.Display.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing Display Class
 */
public class DisplayTest {

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
    public void hasGoodInput1() {
        //[velibnetworkName]
        String[] args = {"myVelib"};
        assertEquals(true, hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput2() {
        //[velibnetworkName]
        String[] args = {"myVelib", "secondArg"};
        assertEquals(false, hasGoodInput(args));
    }
}