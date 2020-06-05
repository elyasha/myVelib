package cli;

import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cli.commands.RunTest.readTextFile;

/**
 * Testing the myvelib CLI class
 */
public class MyVelibCLITest extends TestCase {

    /**
     * Test that need to be implemented
     */
    public void testMain() {
    }

    /**
     * Testing the read text file method with some initial text
     */
    public void testReadTextFile() {
        String filename = "src\\test\\cli\\testReadFileName.txt";
        List<String> result = Arrays.asList("myVelib");
        assertEquals(result, readTextFile(filename));
    }
}