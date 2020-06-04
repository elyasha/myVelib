package cli.commands;

import org.junit.Test;

import static cli.commands.Display.hasGoodInput;
import static org.junit.Assert.*;

public class DisplayTest {

    @Test
    public void main() {
        //TODO
    }

    @Test
    public void hasGoodInput1() {
        //[velibnetworkName]
        String[] args = {"myVelib"};
        assertEquals(true, hasGoodInput(args));
    }

    @Test
    public void hasGoodInput2() {
        //[velibnetworkName]
        String[] args = {"myVelib", "secondArg"};
        assertEquals(false, hasGoodInput(args));
    }
}