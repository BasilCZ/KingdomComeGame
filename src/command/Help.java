package command;

public class Help extends Command {
    //Returns all the usable commands
    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
