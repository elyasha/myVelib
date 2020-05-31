package cli.commands;

public class RentBicycle implements Command {
    /**
     *
     * rentBike <userID, stationID> : to let the user userID renting a bike from station
     * stationID (if no bikes are available should behave accordingly)
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The rentBike command!");
    }

    public static void helpCommand(String[] args) {
        // TODO
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


    public boolean hasGoodInput(String[] args) {
        return false;
    }
}
