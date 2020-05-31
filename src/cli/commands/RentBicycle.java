package cli.commands;

public class RentBicycle implements Command {
    /**
     *
     * rentBicycle <userID, stationID> : to let the user userID renting a bike from station
     * stationID (if no bikes are available should behave accordingly)
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The rentBicycle command!");
            // TODO: Design command
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The rentBicycle command!");
        System.out.println("rentBicycle <userID, stationID> : to let the user userID renting a bike from station stationID (if no bikes are available should behave accordingly)");

    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


    public static boolean hasGoodInput(String[] args) {
        return args.length == 2;
        // TODO: Check to see if it is an integer
    }
}
