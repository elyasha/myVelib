package cli.commands;

import org.junit.Test;

import static cli.commands.DisplayStation.hasGoodInput;
import static org.junit.Assert.*;

public class DisplayStationTest {

    @Test
    public void main() {
        //TODO
    }

    @Test
    public void hasGoodInputTest() {
        //[velibnetworkName, stationID]
        String[] args = {"myVelib", "1"};
        assertEquals(true, hasGoodInput(args));
    }

    @Test
    public void hasGoodInputTest1() {
        //[velibnetworkName, stationID]
        String[] args = {"myVelib", "badID"};
        assertEquals(false, hasGoodInput(args));
    }
}