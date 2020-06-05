package cli.commands;

import org.junit.Test;

import static cli.commands.RunTest.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing RunTest Class
 */
public class RunTestTest {

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
        //[FileName.txt]
        String[] args = {"fileName"};
        assertTrue(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput2() {
        //[FileName.txt]
        String[] args = {"2"};
        assertFalse(hasGoodInput(args));
    }

}