package cli.commands;

import org.junit.Test;

import static cli.commands.RentBicycle.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing RentBicycle Class
 */
public class RentBicycleTest {

    @Test
    public void main() {
    }

    /**
     * Testing good input arguments
     */
    @Test
    public void hasGoodInput1() {
        //[userID, stationID]
        String[] args = {"1", "1"};
        assertTrue(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput2() {
        //[userID, stationID]
        String[] args = {"1", "stringArg"};
        assertFalse(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput3() {
        //[userID, stationID]
        String[] args = {"stringArg", "1"};
        assertFalse(hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInput4() {
        //[userID, stationID]
        String[] args = {};
        assertFalse(hasGoodInput(args));
    }
}