package important;

import enums.BattleChoice;

import java.util.Scanner;

public class Battle {
    public static void battle(Entity e){
        Scanner sc = new Scanner(System.in);
        boolean playerGiveUp = false;
        boolean entityGiveUp = false;
        while(Player.getPlayer().getHp() > 0 && e.getHp() > 0 && !playerGiveUp && !entityGiveUp){
            String input = "";
            boolean correctInput = false;
            int blockingProtection = 0;
            //Player's turn
            while(!correctInput){
                System.out.println("What do you wanna do? (UP, DOWN, LEFT, RIGHT, BLOCK, GIVEUP)");
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
                    System.out.println(e.attack(Player.getPlayer().getWeapon().getDamage(), e.getHelmet()));
                    break;
                case BattleChoice.DOWN:
                    System.out.println(e.attack(Player.getPlayer().getWeapon().getDamage(), e.getLeggings()));
                    break;
                case BattleChoice.LEFT, BattleChoice.RIGHT:
                    System.out.println(e.attack(Player.getPlayer().getWeapon().getDamage(), e.getChestplate()));
                    break;
                case BattleChoice.BLOCK:
                    blockingProtection = 5;
                    break;
                case BattleChoice.GIVEUP:
                    playerGiveUp = true;
                    break;
            }

            //Enemy's turn
            if(!playerGiveUp){

            }
        }
    }
}
