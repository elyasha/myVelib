package cli.commands;

public class AddUser implements Command {
    /**
     *
     * addUser <userName,cardType, velibnetworkName> :
     * to add a user with name {userName} and card {cardType}
     * (i.e. ``none'' if the user has no card) to a myVelib network {velibnetworkName}
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("The addUser command!");
    }
}
