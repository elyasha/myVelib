package cli.commands;

import org.junit.Test;

import static cli.commands.Help.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing Help Class
 */
public class HelpTest {

    @Test
    public void main() {
    }

    /**
     * Testing good input arguments
     */
    @Test
    public void hasGoodInput1() {
        String[] args = {"addManager"};
        assertTrue(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput2() {
        String[] args = {"wrongCommand"};
        assertFalse(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput3() {
        String[] args = {};
        assertTrue(hasGoodInput(args));
    }


}