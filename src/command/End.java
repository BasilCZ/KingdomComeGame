package command;

public class End extends Command {
    /**
     * Ends the game.
     * @return see ya next time
     */
    @Override
    public String execute() {
        return "See ya next time";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
