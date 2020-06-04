package cli.commands;

import org.junit.Test;

import static cli.commands.DisplayUser.hasGoodInput;
import static org.junit.Assert.*;

public class DisplayUserTest {

    @Test
    public void main() {
        //TODO
    }

    @Test
    public void hasGoodInput1() {
        //[velibnetworkName, userID]
        String[] args = {"myVelib", "1"};
        assertEquals(true, hasGoodInput(args));
    }

    @Test
    public void hasGoodInput2() {
        //[velibnetworkName, userID]
        String[] args = {"myVelib", "stringArg"};
        assertEquals(false, hasGoodInput(args));
    }

    @Test
    public void hasGoodInput3() {
        //[velibnetworkName, userID]
        String[] args = {"myVelib", "1", "thirdArg"};
        assertEquals(false, hasGoodInput(args));
    }
}