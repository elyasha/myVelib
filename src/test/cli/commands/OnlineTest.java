package cli.commands;

import org.junit.Test;

import static cli.commands.Online.hasGoodInput;
import static org.junit.Assert.*;

public class OnlineTest {

    @Test
    public void main() {
        //TODO
    }

    @Test
    public void hasGoodInput1() {
        //[velibnetworkName, stationID]
        String[] args = {"myVelib", "1"};
        assertTrue(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput2() {
        String[] args = {"myVelib", "stringArg"};
        assertFalse(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput3() {
        String[] args = {};
        assertFalse(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput4() {
        String[] args = {"myVelib", "1", "arg3"};
        assertFalse(hasGoodInput(args));
    }
}