package cli.commands;

import org.junit.Test;

import static cli.commands.Help.hasGoodInput;
import static org.junit.Assert.*;

public class HelpTest {

    @Test
    public void main() {
    }

    @Test
    public void hasGoodInput1() {
        String[] args = {"addManager"};
        assertTrue(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput2() {
        String[] args = {"wrongCommand"};
        assertFalse(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput3() {
        String[] args = {};
        assertTrue(hasGoodInput(args));
    }



}