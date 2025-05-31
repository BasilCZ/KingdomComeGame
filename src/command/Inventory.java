package command;

import important.Player;

public class Inventory extends Command {
    /**
     * @return Formated <code>String</code> of player's inventory
     */
    @Override
    public String execute() {
        if (Player.getPlayer().getInventory().isEmpty()) {
            return "You don't have anything!";
        } else {
            String inventory = "";
            //Adds all the items in the inventory under each other
            for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
                inventory += Player.getPlayer().getInventory().get(i) + "\n";
            }
            return inventory;
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
