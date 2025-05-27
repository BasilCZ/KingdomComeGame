package command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class History extends Command {
    //Returns all the commands that the user used
    @Override
    public String execute() {
        ArrayList<String> commands = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(Console.allCommands))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                commands.add(line);
            }
            return commands.toString();
        } catch (Exception e) {
            return "History cant be returned";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
