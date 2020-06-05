package cli.commands;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static cli.commands.AddManager.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing add manager class
 */
public class AddManagerTest {

    /**
     * Test that need to be implemented
     */
    @Test
    public void main() {
        //TODO: test AddManager
    }

    /**
     * Testing good input arguments
     */
    @Test
    public void hasGoodInputTest() {
        //addManager [userName,cardType, velibnetworkName]
        String[] args = {"Tom", "Vmax", "myVelib"};
        assertEquals(true, hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInputTest2() {
        //addManager [userName,cardType, velibnetworkName]
        String[] args = {"Tom", " 1 ", "myVelib"};
        assertEquals(false, hasGoodInput(args));
    }
}