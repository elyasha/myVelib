package cli.commands;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static cli.commands.AddManager.hasGoodInput;
import static org.junit.Assert.*;

public class AddManagerTest {

    @Test
    public void main() {
        //TODO: test AddManager
        // Using a boolean variable inside AddManager and see if it's true or not
    }

    @Test
    public void hasGoodInputTest() {
        //addManager [userName,cardType, velibnetworkName]
        String[] args = {"Tom", "Vmax", "myVelib"};
        assertEquals(true, hasGoodInput(args));
    }

    @Test
    public void hasGoodInputTest2() {
        //addManager [userName,cardType, velibnetworkName]
        String[] args = {"Tom", " 1 ", "myVelib"};
        assertEquals(false, hasGoodInput(args));
    }
}