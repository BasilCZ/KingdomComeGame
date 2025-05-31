package command;

import important.Battle;
import important.Entity;
import important.Player;
import world.WorldMap;

import java.util.Random;
import java.util.Scanner;

public class Talk extends Command {
    /**
     * Gives player the dialogue option if there's an entity in the current room.
     * @return <code>String</code> depending on the player's dialogue choice and location
     */
    @Override
    public String execute() {
        WorldMap wm = new WorldMap();
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        for (int i = 0; i < Entity.getEntities().size(); i++) {
            if(Entity.getEntities().get(i).getWhere() == wm.getCurrentId() && Entity.getEntities().get(i).isAlive()){
                Entity e = Entity.getEntities().get(i);
                String input = "";
                while(!input.equals("1)") && !input.equals("2)") && !input.equals("3)") && !input.equals("4)")){
                    System.out.println(e.getName());
                    System.out.println("1) Ask them for money\n2) Ask them for an item\n3) Fight them\n4) Leave them alone");
                    input = sc.nextLine();
                }
                switch(input){
                    case "1)":
                        if(Player.getPlayer().getSpeech() >= e.getSpeech()){
                            if(!e.isGaveMoney()) {
                                Player.getPlayer().changeMoney(e.getMoney() / 4);
                                e.setGaveMoney(true);
                                return "You got " + e.getMoney() / 4 + " money!";
                            } else {
                                return "I already gave you some money!";
                            }
                        } else {
                            return "I'm not giving you anything";
                        }
                    case "2)":
                        if(Player.getPlayer().getCharisma() >= e.getCharisma()){
                            if(!e.getInventory().isEmpty()){
                                if(!e.isGaveItem()) {
                                    int random = rd.nextInt(e.getInventory().size());
                                    Player.getPlayer().addToInventory(e.getInventory().get(random));
                                    e.setGaveItem(true);
                                    return "You got " + e.getInventory().get(random);
                                } else {
                                    return "I already gave you an item";
                                }
                            } else {
                                return "Sorry I dont have anything on me";
                            }
                        } else {
                            return "Get lost";
                        }
                    case "3)":
                        Battle.battle(e);
                        return "";
                }
            }
        }
        return "There's nobody here";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
