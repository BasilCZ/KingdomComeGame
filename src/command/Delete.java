package command;

import java.io.File;

public class Delete extends Command {
    /**
     * Deletes the save file.
     * @return <code>String</code> depending on if the game was deleted or not
     */
    @Override
    public String execute() {
        File file = new File("save.txt");
        if(file.exists()) {
            if (file.delete()) {
                return "You have successfully deleted your save file!";
            } else {
                return "The save file couldn't be deleted";
            }
        }
        return "You don't have a save file!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
