package command;

import java.io.File;

public class Delete extends Command {
    @Override
    public String execute() {
        File file = new File("save.txt");
        if (file.delete()) {
            return "You have successfully deleted your save file!";
        } else {
            return "The save file couldn't be deleted";
        }

    }

    @Override
    public boolean exit() {
        return false;
    }
}
