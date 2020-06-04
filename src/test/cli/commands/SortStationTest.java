package cli.commands;

import org.junit.Test;

import static cli.commands.SortStation.hasGoodInput;
import static org.junit.Assert.*;

public class SortStationTest {

    @Test
    public void main() {
    }

    @Test
    public void hasGoodInput1() {
        //[velibnetworkName, sortpolicy]
        String[] args = {"myVelib", "policy"};
        assertTrue(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput2() {
        //[velibnetworkName, sortpolicy]
        String[] args = {"myVelib"};
        assertTrue(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput3() {
        //[velibnetworkName, sortpolicy]
        String[] args = {"myVelib", "policy", "arg3"};
        assertFalse(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput4() {
        //[velibnetworkName, sortpolicy]
        String[] args = {"test", "1"};
        assertFalse(hasGoodInput(args));
    }
}