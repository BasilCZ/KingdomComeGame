package command;

import important.Player;

import java.util.Scanner;

public class Use extends Command{
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What item do you wanna use?");
        String name = sc.nextLine();
        for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
            if(Player.getPlayer().getInventory().get(i).getName().equalsIgnoreCase(name)){
                int increase = Player.getPlayer().getInventory().get(i).getIncreaseHowMuch();
                switch(Player.getPlayer().getInventory().get(i).getType()){
                    case FOOD:
                        Player.getPlayer().changeHunger(-increase);
                        return "You ate the " + Player.getPlayer().getInventory().get(i).getName();
                    case POTION:
                        if(Player.getPlayer().getInventory().get(i).getIndex() == 6){
                            Player.getPlayer().changeStamina(increase);
                        } else {
                            Player.getPlayer().changeHp(increase);
                        }
                        return "You drank the " + Player.getPlayer().getInventory().get(i).getName();
                }
                Player.getPlayer().getInventory().remove(i);
            }
        }
        return "You cant use that";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
