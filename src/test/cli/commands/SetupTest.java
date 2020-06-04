package cli.commands;

import org.junit.Test;

import static cli.commands.Setup.hasGoodInput;
import static org.junit.Assert.*;

public class SetupTest {

    @Test
    public void main() {
    }

    @Test
    public void hasGoodInput1() {
        //[velibnetworkName]
        // [name, nstations, nslots, s, nbikes]

        String[] args = {"myVelib", "10", "10", "1200", "5"};
        assertTrue(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput2() {
        //[velibnetworkName]
        // [name, nstations, nslots, s, nbikes]

        String[] args = {"myVelib", "10", "10", "1200", "15"};
        assertFalse(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput3() {
        //[velibnetworkName]
        // [name, nstations, nslots, s, nbikes]

        String[] args = {"myVelib", "stringArg", "10", "1200", "5"};
        assertFalse(hasGoodInput(args));
    }


}