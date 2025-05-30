package command;

import important.Player;

import java.util.Scanner;

public class Read extends Command {
    @Override
    public String execute() {
        System.out.println(new Inventory().execute());
        if(!Player.getPlayer().getInventory().isEmpty()) {
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
                if(Player.getPlayer().getInventory().get(i).getName().equalsIgnoreCase(sc.next())){
                    switch(Player.getPlayer().getInventory().get(i).getType()){
                        case BOOK:
                            Player.getPlayer().getInventory().remove(i);
                            Player.getPlayer().changeCharisma(3);
                            break;
                        case LETTER:
                            Player.getPlayer().getInventory().remove(i);
                            Player.getPlayer().changeSpeech(3);
                            break;
                        default:
                            return "You cant read that!";
                    }
                }
            }
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
