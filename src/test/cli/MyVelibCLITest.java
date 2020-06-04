package cli;

import junit.framework.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static cli.commands.RunTest.readTextFile;


public class MyVelibCLITest extends TestCase {

    public void testMain() {
    }

    public void testReadTextFile() {
        String filename = "src\\test\\cli\\testReadFileName.txt";
        List<String> result = Arrays.asList("myVelib");
        assertEquals(result, readTextFile(filename));
    }
}