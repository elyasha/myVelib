package cli.commands;

public class ReturnBicycle implements Command {
    /**
     *
     * returnBicycle <userID, stationID, time> : to let the user userID returning a bicycle
     * to station stationID at a given instant of time time (if no parking bay is available
     * should behave accordingly). This command should display the cost of the rent
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The returnBike command!");
            // TODO: Design command
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The returnBicycle command!");
        System.out.println("returnBicycle <userID, stationID, time> : to let the user userID returning a bike to station stationID at a given instant of time time (if no parking bay is available should behave accordingly). This command should display the cost of the rent");
    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


    public static boolean hasGoodInput(String[] args) {
        return args.length == 2;
    }
}
