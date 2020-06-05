package cli.commands;

import org.junit.Test;

import static cli.commands.Exit.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing Exit Class
 */
public class ExitTest {

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
        String[] args = {};
        assertEquals(true, hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput2() {
        String[] args = {"badArg"};
        assertEquals(false, hasGoodInput(args));
    }
}