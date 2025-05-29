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
            //Player's turn
            while(!correctInput){
                input = sc.next();
                for (int i = 0; i < BattleChoice.values().length; i++) {
                    if (BattleChoice.values()[i].name().equalsIgnoreCase(input)) {
                        correctInput = true;
                        break;
                    }
                }
            }
            switch(BattleChoice.valueOf(input)){
                case BattleChoice.UP:

                case BattleChoice.DOWN:

                case BattleChoice.LEFT:

                case BattleChoice.RIGHT:

                case BattleChoice.BLOCK:

                case BattleChoice.GIVEUP:

            }



            //Enemy's turn
        }
    }
}
