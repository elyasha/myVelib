package cli.commands;

import cli.RunCommand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the RunTest class that implements the runTest command of the CLI.
 * runTest [FileName.txt] :
 * to run a test (sequence of commands) from a file name fileName.txt
 */
public class RunTest implements Command {
    /**
     * main() is the implementation of the command. It will interact with the core.Main application
     * the runTest command: Run the test suite of the myVelib framework
     *
     * @param args the arguments of the command
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        } else {
//            System.out.println("The runTest command");
            if (args.length == 0) {
                // While loop to run commands
                System.out.println("Please add an argument with the path to the file that you are going to test!");
                System.out.println("Usage: runTest [fileName.txt]");

            } else {

                String fileName = args[0];

                // Read file.txt and execute commands
                // TODO: check commands. For now, we assume the file has no errors
                List<String> textFile = readTextFile(fileName);


                boolean fileHasProblem = false; // We assume the file is correct

                // Check line by line

                // If success : run the file line by line
                if (!fileHasProblem) {
                    // run the file

                    // Read file line by line (check if the first word is a command)
                    for (String s : textFile) {
                        // Execute the line
                        String command = s.split(" ")[0];
//                    System.out.println(command);
                        String[] argsCommand = s.split(" ");

                        // Uncomment for tests
//                        for (String value : argsCommand) {
//                            System.out.println(value);
//                        }

                        RunCommand.main(argsCommand);

                    }
                } else {
                    System.out.println("You file has a syntax error!");
                }
            }
        }
    }

    /**
     * This is the help command: it displays a message to better explain the command itself
     *
     * @param args the arguments of the command
     */
    public static void helpCommand(String[] args) {
        System.out.println("The runTest command");
        System.out.println("the runTest command: Run the test suite of the myVelib framework");
    }

    /**
     * This method implements all the help that will be displayed to the user if he enters a wrong input
     */
    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }

    /**
     * This methods is used to check if the command has good input from the user
     *
     * @param args the arguments of the command
     * @return true, if the command has good input. false, otherwise
     */
    public static boolean hasGoodInput(String[] args) {
        if (args.length > 1) {
            return false;
        }
        try {
            int integerValue1 = Integer.parseInt(args[0]);
            System.out.println("Wrong data type. Expecting a string! Please see your file.txt ;)");
            return false;
        } catch (NumberFormatException numberFormatException) {
            return true;
        }
    }

    public static List<String> readTextFile(String fileName) {

        List<String> returnValue = new ArrayList<String>();
        FileReader file = null;
        BufferedReader reader = null;

        try {
            // open input stream pointing at fileName
            file = new FileReader(fileName);

            // open input buffered reader to read file line by line
            reader = new BufferedReader(file);
            String line = "";

            // reading input file line by line
            while ((line = reader.readLine()) != null) {
                returnValue.add(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (file != null) {
                try {
                    file.close();
                    reader.close();

                } catch (IOException e) {
                    System.out.println("File not found: " + fileName);
                    // Ignore issues during closing
                }
            }
        }
        return returnValue;
    }
}
