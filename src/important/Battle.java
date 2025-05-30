package important;

import command.GameOver;
import enums.BattleChoice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Battle {
    public static void battle(Entity e){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
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
                    break;
                case BattleChoice.DOWN:
                    System.out.println("You did: " + e.attack(Player.getPlayer().getWeapon().getDamage(), e.getLeggings(), enemyBlock) + " damage!");
                    break;
                case BattleChoice.LEFT, BattleChoice.RIGHT:
                    System.out.println("You did: " + e.attack(Player.getPlayer().getWeapon().getDamage(), e.getChestplate(), enemyBlock) + " damage!");
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
                        break;
                    case BattleChoice.DOWN:
                        System.out.println("The enemy did: " + Player.getPlayer().attack(e.getWeapon().getDamage(), Player.getPlayer().getLeggings(), playerBlock) + " damage!");
                        break;
                    case BattleChoice.LEFT, BattleChoice.RIGHT:
                        System.out.println("The enemy did: " + Player.getPlayer().attack(e.getWeapon().getDamage(), Player.getPlayer().getChestplate(), playerBlock) + " damage!");
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
                    for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
                        for (int j = 0; j < e.getInventory().size(); j++) {
                            if(Player.getPlayer().getInventory().get(i).getIndex() == e.getInventory().get(j).getIndex()){
                                Player.getPlayer().getInventory().get(i).increaseHowMany();
                            }
                        }
                    }
                    break;
                case "3)":
                    System.out.println("You killed them");
                    e.setHp(0);
                    e.setAlive(false);
                    break;
            }
        }
        if(Player.getPlayer().getHp() == 0){
            System.out.println(new GameOver().execute());
        }
        if(e.getHp() == 0){
            e.setAlive(false);
            String input = "";
            while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")){
                System.out.println("Do you wanna loot their body? (Yes/No)");
                input = sc.next();
            }
            switch(input.toLowerCase()){
                case "yes":
                    System.out.println("You looted the body");
                    Player.getPlayer().changeMoney(e.getMoney());
                    for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
                        for (int j = 0; j < e.getInventory().size(); j++) {
                            if(Player.getPlayer().getInventory().get(i).getIndex() == e.getInventory().get(j).getIndex()){
                                Player.getPlayer().getInventory().get(i).increaseHowMany();
                            }
                        }
                    }
                    break;
                case "no":
                    System.out.println("You let the body rot on the ground");
            }
        }
    }
}
