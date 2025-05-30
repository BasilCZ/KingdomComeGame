package command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> map = new HashMap<>();
    public static String allCommands = "Commands.txt";

    public void initialization() {
        map.put("help", new Help());
        map.put("history", new History());
        map.put("move", new Move());
        map.put("inventory", new Inventory());
        map.put("end", new End());
        map.put("delete", new Delete());
        map.put("save", new Save());
        map.put("shop", new Shop());
        map.put("equip", new Equip());
        map.put("read", new Read());
        map.put("talk", new Talk());
        map.put("travel", new Travel());
        map.put("equipment", new Equipment());
        map.put("sleep", new Sleep());
        map.put("stats", new Stats());
        map.put("use", new Use());
    }

    private Scanner scanner = new Scanner(System.in);

    private void proved() {
        System.out.print(">> ");
        String command = scanner.nextLine();
        command = command.trim();
        command = command.toLowerCase();
        saveCommand(command);
        if (map.containsKey(command)) {
            System.out.println(">> " + map.get(command).execute());
            exit = map.get(command).exit();
        } else {
            System.out.println(">> Command not found");
        }
    }

    public void start() {
        initialization();
        try {
            resetAllCommands();
            do {
                proved();
            } while (!exit);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void saveCommand(String command) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(allCommands, true))) {
            bw.write(command);
            bw.newLine();
        } catch (IOException e) {
        }
    }

    private void resetAllCommands() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(allCommands, false))) {
        } catch (Exception e) {
        }
    }
}
