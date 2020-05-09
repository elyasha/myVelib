package cli.commands;

public class ReturnBike implements Command {
    /**
     *
     * returnBike <userID, stationID, time> : to let the user userID returning a bike
     * to station stationID at a given instant of time time (if no parking bay is available
     * should behave accordingly). This command should display the cost of the rent
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The returnBike command!");
    }
}
