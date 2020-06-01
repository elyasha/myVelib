package cli;

import cli.states.State;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;

public class MyVelibCLI {

    private State state;
    private final String[] listOfCommands = {"addManager", "addUser", "display", "displayStation", "displayUser", "exit", "help", "offline", "online", "rentBicycle", "returnBicycle", "runTest", "setup", "sortStation"};

    public State getState() {
        return state;
    }

    public String[] getListOfCommands() {
        return listOfCommands;
    }

    public void setState(State state) {
        this.state = state;
        this.state.onEnterState();
    }

    // Create a method to know how to change the state of the CLI

    public static void main(String[] args) {
        if (args.length == 0) {
            // While loop to run commands
            // TODO: With the state pattern, create an interactive cli

        }
        else {

            String fileName = args[0];

            // Read file.txt and execute commands
            // TODO: Read file, check commands and execute commands
            List<String> textFile = readTextFile(fileName);

//            System.out.println(textFile.get(2));
            // Read file line by line (check if the first word is a command)

            boolean fileHasProblem = false; // We assume the file is correct

            // Check line by line
            // TODO:




            // If success : run the file line by line
            if (!fileHasProblem) {
                // run the file
                // TODO: Run each line
                for (int i = 0; i < textFile.size(); i++) {
                    // Execute the line
                    String command = textFile.get(i).split(" ")[0];
//                    System.out.println(command);
                    String[] argsCommand = textFile.get(i).split(" ");

                    for (int j = 0; j < argsCommand.length; j++) {
                        System.out.println(argsCommand[j]);
                    }
                    RunCommand.main(argsCommand);

                }
            }
            else {
                System.out.println("You file has a syntax error!");
            }
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
