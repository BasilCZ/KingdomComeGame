package command;

import important.Entity;
import world.WorldMap;

import java.util.Scanner;

public class Talk extends Command {
    @Override
    public String execute() {
        WorldMap wm = new WorldMap();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < Entity.getEntities().size(); i++) {
            if(Entity.getEntities().get(i).getWhere() == wm.getCurrentId() && Entity.getEntities().get(i).isAlive()){
                String input = "";
                while(!input.equals("1)") && !input.equals("2)") && !input.equals("3)") && !input.equals("4)")){
                    System.out.println(Entity.getEntities().get(i).getName());
                    System.out.println("1) Ask them for money\n2) Do something\n3) Fight them\n4) Leave them alone");
                    input = sc.nextLine();
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
