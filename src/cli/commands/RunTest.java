package cli.commands;

import cli.RunCommand;

import java.io.*;
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
                System.out.println("Please add an argument with the path to the file that you are going to test");
                System.out.println("Usage: runTest [fileName.txt]");

            } else {


                String fileName = args[0];
                // We assume the fileName will have the .txt extension
                String fileOutputName = args[0].substring(0, args[0].length() - 4) + "OUTPUT.txt";
                // TODO: write on the file output

                // Read file.txt and execute commands
                // TODO: check commands. For now, we assume the file has no errors. Of course, when executing the file, the commands will output a message saying it has an wrong input
                List<String> textFile = readTextFile(fileName);


                boolean fileHasProblem = false; // We assume the file is correct

                // Check line by line

                // If success : run the file line by line
                if (!fileHasProblem) {
                    // run the file

                    // Read file line by line (check if the first word is a command)
                    for (String s : textFile) {
                        // Execute the line
                        String[] argsCommand = s.split(" ");

                        // Uncomment for tests
//                        for (String value : argsCommand) {
//                            System.out.println(value);
//                        }

                        RunCommand.main(argsCommand);

                    }
                } else {
                    System.out.println("You file has a syntax error");
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
        System.out.println("There is a problem with the arguments passed");
        System.out.println("Please add some (consistent) argument. For help: myvelib help [COMMAND]");
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
            System.out.println("Wrong data type. Expecting a string. Please see your file.txt ;)");
            return false;
        } catch (NumberFormatException numberFormatException) {
            return true;
        }
    }

    /**
     * This method reads text file
     *
     * @param fileName: name of the file we want to read
     * @return: string that wad contained in the fileName
     */
    public static List<String> readTextFile(String fileName) {

        List<String> returnValue = new ArrayList<>();
        FileReader file = null;
        BufferedReader reader = null;

        try {
            // open input stream pointing at fileName
            file = new FileReader(fileName);

            // open input buffered reader to read file line by line
            reader = new BufferedReader(file);
            String line;

            // reading input file line by line
            while ((line = reader.readLine()) != null) {
                returnValue.add(line);
            }
        } catch (Exception e) {
            System.out.println("The file cannot be found. If you are running tests, please use (without the {} and change nameOfTheTest):");
            System.out.println("runTest eval\\tests\\{nameOfTheTest}.txt");
        } finally {
            if (file != null) {
                try {
                    file.close();
                    assert reader != null;
                    reader.close();

                } catch (IOException e) {
                    System.out.println("File not found: " + fileName);
                    // Ignore issues during closing
                }
            }
        }
        return returnValue;


    }

    /**
     * This method writes in a text file
     *
     * @param fileName: name of the file we want to read
     * @param s:        what we want to write in the file
     */
    public static void writeTextFile(String fileName, String s) {
        FileWriter output = null;
        try {
            output = new FileWriter(fileName);
            BufferedWriter writer = new BufferedWriter(output);
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                    System.out.println("writing file " + fileName + " closing");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("writing file " + fileName + " IOException");
                }
            }
        }

    }
}
