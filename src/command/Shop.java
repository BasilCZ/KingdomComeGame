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
                System.out.println("1) " + shop.get(0) + "\n2) " + shop.get(1) + "\n3) " + shop.get(2));
                input = sc.next();
                switch(input){
                    case "1)":
                        if(Player.getPlayer().getMoney() >= shop.get(0).getValue()){
                            Player.getPlayer().changeMoney(-shop.get(0).getValue());
                            Player.getPlayer().addToInventory(shop.get(0));
                        } else {
                            System.out.println("You don't have enough!");
                        }
                        break;
                    case "2)":
                        if(Player.getPlayer().getMoney() >= shop.get(1).getValue()){
                            Player.getPlayer().changeMoney(-shop.get(1).getValue());
                            Player.getPlayer().addToInventory(shop.get(1));
                        } else {
                            System.out.println("You don't have enough!");
                        }
                        break;
                    case "3)":
                        if(Player.getPlayer().getMoney() >= shop.get(2).getValue()){
                            Player.getPlayer().changeMoney(-shop.get(2).getValue());
                            Player.getPlayer().addToInventory(shop.get(2));
                        } else {
                            System.out.println("You don't have enough!");
                        }
                        break;
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
