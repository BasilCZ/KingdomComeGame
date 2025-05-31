package important;

import command.GameOver;
import enums.BattleChoice;
import world.WorldMap;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static void battle(Entity e){
        Random rd = new Random();
        WorldMap wm = new WorldMap();
        switch(rd.nextInt(2)){
            case 0:
                Music.setFileName("fight.wav");
                break;
            case 1:
                Music.setFileName("fight2.wav");
                break;
        }
        Music.play();
        Scanner sc = new Scanner(System.in);
        boolean playerGiveUp = false;
        boolean enemyGiveUp = false;
        int playerBlock = 0;
        int enemyBlock = 0;
        while(Player.getPlayer().getHp() > 0 && e.getHp() > 0 && !playerGiveUp && !enemyGiveUp){
            String input = "";
            boolean correctInput = false;
            enemyBlock = 0;
            //Player's turn
            while(!correctInput){
                System.out.println("Player\nHp: " + Player.getPlayer().getHp() + "\nStamina: " + Player.getPlayer().getStamina() + "\n");
                System.out.println(e.getName() + "\nHp: " + e.getHp() + "\nStamina: " + e.getStamina() + "\n");
                System.out.println("What do you wanna do? " + Arrays.toString(BattleChoice.values()));
                input = sc.next();
                for (int i = 0; i < BattleChoice.values().length; i++) {
                    if (BattleChoice.values()[i].name().equalsIgnoreCase(input)) {
                        correctInput = true;
                        break;
                    }
                }
            }
            switch(BattleChoice.valueOf(input.toUpperCase())){
                case BattleChoice.UP:
                    System.out.println("You did: " + e.attack(Player.getPlayer().getWeapon().getDamage(), e.getHelmet(), enemyBlock) + " damage!");
                    Player.getPlayer().changeStamina(-Player.getPlayer().getWeapon().getStaminaCost());
                    e.getHelmet().changeDurability(-2);
                    Player.getPlayer().getWeapon().changeDurability(-1);
                    break;
                case BattleChoice.DOWN:
                    System.out.println("You did: " + e.attack(Player.getPlayer().getWeapon().getDamage(), e.getLeggings(), enemyBlock) + " damage!");
                    Player.getPlayer().changeStamina(-Player.getPlayer().getWeapon().getStaminaCost());
                    e.getChestplate().changeDurability(-2);
                    Player.getPlayer().getWeapon().changeDurability(-1);
                    break;
                case BattleChoice.LEFT, BattleChoice.RIGHT:
                    System.out.println("You did: " + e.attack(Player.getPlayer().getWeapon().getDamage(), e.getChestplate(), enemyBlock) + " damage!");
                    Player.getPlayer().changeStamina(-Player.getPlayer().getWeapon().getStaminaCost());
                    e.getLeggings().changeDurability(-2);
                    Player.getPlayer().getWeapon().changeDurability(-1);
                    break;
                case BattleChoice.BLOCK:
                    System.out.println("You're blocking!");
                    playerBlock = 5;
                    Player.getPlayer().changeStamina(10);
                    break;
                case BattleChoice.GIVEUP:
                    System.out.println("You gave up!");
                    playerGiveUp = true;
                    break;
            }

            //Enemy's turn
            if(!playerGiveUp){
                BattleChoice choice = BattleChoice.GIVEUP;
                while(choice == BattleChoice.GIVEUP){
                    choice = BattleChoice.values()[rd.nextInt(BattleChoice.values().length)];
                }
                if(e.getHp() < e.getMaxHp()/15 && rd.nextInt() >= 3){
                    choice = BattleChoice.GIVEUP;
                }
                switch(choice){
                    case BattleChoice.UP:
                        System.out.println("The enemy did: " + Player.getPlayer().attack(e.getWeapon().getDamage(), Player.getPlayer().getHelmet(), playerBlock) + " damage!");
                        e.changeStamina(-e.getWeapon().getStaminaCost());
                        Player.getPlayer().getHelmet().changeDurability(-2);
                        e.getWeapon().changeDurability(-1);
                        break;
                    case BattleChoice.DOWN:
                        System.out.println("The enemy did: " + Player.getPlayer().attack(e.getWeapon().getDamage(), Player.getPlayer().getLeggings(), playerBlock) + " damage!");
                        e.changeStamina(-e.getWeapon().getStaminaCost());
                        Player.getPlayer().getChestplate().changeDurability(-2);
                        e.getWeapon().changeDurability(-1);
                        break;
                    case BattleChoice.LEFT, BattleChoice.RIGHT:
                        System.out.println("The enemy did: " + Player.getPlayer().attack(e.getWeapon().getDamage(), Player.getPlayer().getChestplate(), playerBlock) + " damage!");
                        e.changeStamina(-e.getWeapon().getStaminaCost());
                        Player.getPlayer().getLeggings().changeDurability(-2);
                        e.getWeapon().changeDurability(-1);
                        break;
                    case BattleChoice.BLOCK:
                        System.out.println("The enemy is blocking!");
                        e.changeStamina(10);
                        enemyBlock = 5;
                        break;
                    case BattleChoice.GIVEUP:
                        enemyGiveUp = true;
                        break;
                }
            }
            playerBlock = 0;
        }
        if(playerGiveUp){
            System.out.println("You got robbed and lost " + Player.getPlayer().getMoney()/5 + " money");
            Player.getPlayer().changeMoney(-Player.getPlayer().getMoney()/5);
        }
        if(enemyGiveUp) {
            System.out.println("They're giving up!");
            String input = "";
            while(!input.equals("1)") && !input.equals("2)") && !input.equals("3)")){
                System.out.println("What do you wanna do with them?\n1) Let them go\n2) Rob him and let them go\n3) Kill them");
                input = sc.next();
            }
            switch(input){
                case "1)":
                    System.out.println("You let them go");
                    break;
                case "2)":
                    System.out.println("You robbed them!");
                    Player.getPlayer().changeMoney(e.getMoney());
                    for (int i = 0; i < e.getInventory().size(); i++) {
                        Player.getPlayer().addToInventory(e.getInventory().get(i));
                    }
                    break;
                case "3)":
                    System.out.println("You killed them");
                    e.setHp(0);
                    for (int i = 0; i < Entity.getEntities().size(); i++) {
                        if(e.getIndex() == Entity.getEntities().get(i).getIndex()){
                            Entity.getEntities().get(i).setAlive(false);
                        }
                    }
                    break;
            }
        }
        if(Player.getPlayer().getHp() == 0){
            System.out.println(new GameOver().execute());
            new GameOver().exit();
        }
        if(e.getHp() == 0){
            for (int i = 0; i < Entity.getEntities().size(); i++) {
                if(e.getIndex() == Entity.getEntities().get(i).getIndex()){
                    Entity.getEntities().get(i).setAlive(false);
                }
            }
            String input = "";
            while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")){
                System.out.println("Do you wanna loot their body? (Yes/No)");
                input = sc.next();
            }
            switch(input.toLowerCase()){
                case "yes":
                    System.out.println("You looted the body");
                    Player.getPlayer().changeMoney(e.getMoney());
                    for (int i = 0; i < e.getInventory().size(); i++) {
                        Player.getPlayer().addToInventory(e.getInventory().get(i));
                    }
                    break;
                case "no":
                    System.out.println("You let the body rot on the ground");
            }
        }
        switch(wm.getCurrentPosition().getLocationType()){
            case FOREST:
                Music.setFileName("forest.wav");
                break;
            case MOTEL:
                Music.setFileName("motel.wav");
                break;
            case HOUSE:
                Music.setFileName("house.wav");
                break;
            default:
                Music.setFileName("other.wav");
                break;
        }
        switch(wm.getCurrentPosition().getName()){
            case "Semine":
                Music.setFileName("semine.wav");
                break;
            case "Kuttenberg":
                Music.setFileName("kuttenberg.wav");
                break;
        }
        Music.play();
        Player.getPlayer().changeStamina(100000);
    }
}
