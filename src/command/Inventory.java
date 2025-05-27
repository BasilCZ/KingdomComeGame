package command;

import important.Player;

public class Inventory extends Command {
    //Returns player's inventory
    @Override
    public String execute() {
        Player p = new Player();
        if (p.getInventory().isEmpty()) {
            return "You don't have anything!";
        } else {
            String inventory = "";
            //Adds all the items in the inventory under each other
            for (int i = 0; i < p.getInventory().size(); i++) {
                inventory += p.getInventory().get(i) + "\n";
            }
            return inventory;
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
