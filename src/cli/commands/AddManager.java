package cli.commands;

public class AddManager implements Command {
    /**
     *
     * addManager <userName,cardType, velibnetworkName> :
     * to add a user with name {userName} and card {cardType}
     * (i.e. ``none'' if the user has no card) to a myVelib network {velibnetworkName}
     *
     * @param args
     */
    public static void main(String[] args) {
        if (!hasGoodInput(args)) {
            wrongArgumentHelp();
        }
        else {
            System.out.println("The addManager command!");
            // TODO: Design the command
        }
    }

    public static boolean hasGoodInput(String[] args) {
        // Check the quantity of arguments in this command
        if (args.length != 3){
            return false;
        }
        else{
            // Check if the cardType is well written
            if (!args[1].equals("Vmax") && !args[1].equals("Vlibre")) {
                CardTypeError();
                return false;
            }
            else {
                return true;
            }
        }
    }

    private static void CardTypeError() {
        System.out.println("There is an error in the card type!");
        System.out.println("Please, add a coherent card type (Vmax, Vlibre, none)");
    }

    public static void helpCommand(String[] args) {
        System.out.println("The addManager command!");
        System.out.println("addManager <userName,cardType, velibnetworkName> :");
        System.out.println("to add a user with name {userName} and card {cardType:Vmax/Vlibre/none}");
        System.out.println("(i.e. ``none'' if the user has no card) to a myVelib network {velibnetworkName}");

    }

    public static void wrongArgumentHelp() {
        System.out.println("There is a problem with the arguments passed!");
        System.out.println("Please add some (consistent) argument! For help: myvelib help [COMMAND]");
    }
}
