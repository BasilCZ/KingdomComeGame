package command;

import enums.LocationType;
import important.Armor;
import important.Item;
import important.Player;
import important.Weapon;
import world.WorldMap;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Shop extends Command{
    /**
     * Opens the shop and lets player buy/fix things.
     * @return <code>String</code> depending on the player's input
     */
    @Override
    public String execute() {
        WorldMap wm = new  WorldMap();
        if(wm.getCurrentPosition().getLocationType() == LocationType.SHOP){
            Scanner sc = new Scanner(System.in);
            String input = "";
            Random rd = new Random();
            ArrayList<Item> shop = new ArrayList<Item>();
            shop.add(Item.getItems().get(rd.nextInt(Item.getItems().size())));
            shop.add(Weapon.getWeapons().get(rd.nextInt(Weapon.getWeapons().size())));
            shop.add(Armor.getArmors().get(rd.nextInt(Armor.getArmors().size())));
            while(!input.equalsIgnoreCase("exit")){
                System.out.println("To exit the shop type \"exit\"");
                System.out.println("1) " + shop.get(0) + "\n2) " + shop.get(1) + "\n3) " + shop.get(2) + "\n4) " + "Fix equipment");
                input = sc.nextLine();
                switch(input){
                    case "1)":
                        if(Player.getPlayer().getMoney() >= shop.get(0).getValue()){
                            Player.getPlayer().changeMoney(-shop.get(0).getValue());
                            Player.getPlayer().addToInventory(shop.get(0));
                            return "You bought " + shop.get(0).getName();
                        } else {
                            return "You don't have enough!";
                        }
                    case "2)":
                        if(Player.getPlayer().getMoney() >= shop.get(1).getValue()){
                            Player.getPlayer().changeMoney(-shop.get(1).getValue());
                            Player.getPlayer().addToInventory(shop.get(1));
                            return "You bought " + shop.get(1).getName();
                        } else {
                            return "You don't have enough!";
                        }
                    case "3)":
                        if(Player.getPlayer().getMoney() >= shop.get(2).getValue()){
                            Player.getPlayer().changeMoney(-shop.get(2).getValue());
                            Player.getPlayer().addToInventory(shop.get(2));
                            return "You bought " + shop.get(2).getName();
                        } else {
                            return "You don't have enough!";
                        }
                    case "4)":
                        System.out.println("What do you wanna fix? (3 gold per equipment)");
                        input = sc.nextLine();
                        for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
                            if(Player.getPlayer().getInventory().get(i).getName().equalsIgnoreCase(input) && (Player.getPlayer().getInventory().get(i) instanceof Armor || Player.getPlayer().getInventory().get(i) instanceof Weapon)){
                                if(Player.getPlayer().getMoney() >= 3){
                                    Player.getPlayer().changeMoney(-3);
                                    Player.getPlayer().getInventory().get(i).setDurability(100);
                                    return "You fixed " + Player.getPlayer().getInventory().get(i).getName();
                                } else {
                                    return "You dont have enough!";
                                }
                            }
                        }
                        return "Cant fix that";
                }
            }
            return "You left the shop!";
        } else {
            return "There isnt a shop nowhere near you";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
