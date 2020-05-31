package cli.commands;

public interface Command {

    public boolean hasGoodInput(String[] args);
    public void helpCommand();





}
