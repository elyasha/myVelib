package cli.commands;

public class Setup implements Command {
    /**
     *
     * setup <velibnetworkName>: to create a myVelib network with given name and
     * consisting of 10 stations each of which has 10 parking slots and such that stations
     * are arranged on a square grid whose of side 4km and initially populated with a 75%
     * bikes randomly distributed over the 10 stations
     *
     * setup <name> <nstations> <nslots> <s> <nbikes>: to create a myVelib net-
     * work with given name and consisting of nstations stations each of which has nslots
     * parking slots and such that stations are arranged in as uniform as possible manner
     * over an area you may assume either being circular of radium s or squared of side s
     * (please document what kind of area your implementation of this command takes into
     * account and how stations are distributed over it).Furthermore the network should
     * be initially populated with a nbikes bikes randomly distributed over the nstations
     * stations
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else{
            System.out.println("The setup command!");
            // TODO: Design command
        }
    }

    public static void helpCommand(String[] args) {
        System.out.println("The setup command!");
        System.out.println();
        System.out.println("setup <velibnetworkName>: to create a myVelib network with given name and");
        System.out.println("consisting of 10 stations each of which has 10 parking slots and such that stations");
        System.out.println("are arranged on a square grid whose of side 4km and initially populated with a 75%");
        System.out.println("bikes randomly distributed over the 10 stations");
        System.out.println();
        System.out.println("setup <name> <nstations> <nslots> <s> <nbikes>: to create a myVelib network");
        System.out.println("with given name and consisting of nstations stations each of which has nslots");
        System.out.println("parking slots and such that stations are arranged in as uniform as possible manner");
        System.out.println("over an area you may assume either being circular of radium s or squared of side s");
        System.out.println("");





    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }


    public static boolean hasGoodInput(String[] args) {
        return args.length == 1 || args.length == 5;
        // TODO: Check to see if it is an integer

    }
}
