package cli.commands;

import org.junit.Test;

import static cli.commands.Exit.hasGoodInput;
import static org.junit.Assert.*;

public class ExitTest {

    @Test
    public void main() {
    }

    @Test
    public void hasGoodInput1() {
        String[] args = {};
        assertEquals(true, hasGoodInput(args));
    }

    @Test
    public void hasGoodInput2() {
        String[] args = {"badArg"};
        assertEquals(false, hasGoodInput(args));
    }
}