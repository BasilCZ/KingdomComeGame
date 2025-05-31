package command;

import loading_and_saving.SaveGame;

public class Save extends Command{
    /**
     * Saves the game.
     * @return <code>String</code> whether the game has been saved or not
     */
    @Override
    public String execute() {
        if(SaveGame.save()){
            return "Game saved!";
        } else {
            return "Game could not be saved!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
