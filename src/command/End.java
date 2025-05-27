package command;

public class End extends Command {

    @Override
    public String execute() {
        return "See ya next time";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
