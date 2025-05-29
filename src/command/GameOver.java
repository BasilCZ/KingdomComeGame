package command;

public class GameOver extends Command{
    @Override
    public String execute() {
        return "You died";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
