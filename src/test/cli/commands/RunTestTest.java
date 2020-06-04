package cli.commands;

import org.junit.Test;

import static cli.commands.RunTest.hasGoodInput;
import static org.junit.Assert.*;

public class RunTestTest {

    @Test
    public void main() {
    }

    @Test
    public void hasGoodInput1() {
        //[FileName.txt]
        String[] args = {"fileName"};
        assertTrue(hasGoodInput(args));
    }

    @Test
    public void hasGoodInput2() {
        //[FileName.txt]
        String[] args = {"2"};
        assertFalse(hasGoodInput(args));
    }

}