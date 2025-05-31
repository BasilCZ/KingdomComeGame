package command;

import important.Player;

import java.util.Scanner;

public class Use extends Command{
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
            if(Player.getPlayer().getInventory().get(i).getName().equalsIgnoreCase(name)){
                int increase = Player.getPlayer().getInventory().get(i).getIncreaseHowMuch();
                switch(Player.getPlayer().getInventory().get(i).getType()){
                    case FOOD:
                        Player.getPlayer().changeHunger(-increase);
                    case POTION:
                        if(Player.getPlayer().getInventory().get(i).getIndex() == 6){
                            Player.getPlayer().changeStamina(increase);
                        } else {
                            Player.getPlayer().changeHp(increase);
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
