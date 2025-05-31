package command;

import important.Item;
import important.Player;

import java.util.Scanner;

public class Read extends Command {
    /**
     * Reads something and increases the specific stat.
     * @return <code>String</code> what you've read
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println(new Inventory().execute());
        if(!Player.getPlayer().getInventory().isEmpty()) {
            String input = sc.nextLine();
            for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
                if(Player.getPlayer().getInventory().get(i).getName().equalsIgnoreCase(input)){
                    int id = Player.getPlayer().getInventory().get(i).getIndex();
                    switch(Player.getPlayer().getInventory().get(i).getType()){
                        case BOOK:
                            Player.getPlayer().changeCharisma(Player.getPlayer().getInventory().get(i).getIncreaseHowMuch());
                            Player.getPlayer().getInventory().remove(i);
                            return "You read the " + Item.getItems().get(id).getName();
                        case LETTER:
                            Player.getPlayer().changeSpeech(Player.getPlayer().getInventory().get(i).getIncreaseHowMuch());
                            Player.getPlayer().getInventory().remove(i);
                            return "You read the " + Item.getItems().get(id).getName();
                    }
                }
            }
        }
        return "You cant read that!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
