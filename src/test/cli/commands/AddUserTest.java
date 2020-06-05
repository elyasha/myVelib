package cli.commands;

import org.junit.Test;

import static cli.commands.AddUser.hasGoodInput;
import static org.junit.Assert.*;

/**
 * Testing add user class
 */
public class AddUserTest {

    @Test
    public void main() {
        // TODO: AddUser
    }

    /**
     * Testing good input arguments
     */
    @Test
    public void hasGoodInputTest() {
        //addUser [userName,cardType, velibnetworkName]
        String[] args = {"Tom", "Vmax", "myVelib"};
        assertEquals(true, hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInputTest2() {
        //addUser [userName,cardType, velibnetworkName]
        String[] args = {"Tom", " 1 ", "myVelib"};
        assertEquals(false, hasGoodInput(args));
    }

    /**
     * Testing bad input arguments
     */
    @Test
    public void hasGoodInputTest3() {
        //addUser [userName,cardType, velibnetworkName]
        String[] args = {"Tom", " ", "myVelib"};
        assertEquals(false, hasGoodInput(args));
    }
}