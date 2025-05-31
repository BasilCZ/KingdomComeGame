package command;

public class GameOver extends Command{
    @Override
    public String execute() {
        System.out.println("You died");
        System.exit(0);
        return null;
    }

    @Override
    public boolean exit() {
        return true;
    }
}
