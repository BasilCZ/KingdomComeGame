package command;

import important.Music;
import important.Player;
import world.Location;
import world.WorldMap;

import java.util.Scanner;

public class Move extends Command {
    /**
     * Moves the player to a new room and changes the music depending on the room.
     * @return <code>String</code> room to which you moved to
     */
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        Location currentLocation = new Location();
        WorldMap world = new WorldMap();
        currentLocation = world.getCurrentPosition();
        System.out.println(">> You are currently at: " + currentLocation.getName());
        System.out.println(">> Where would you like to move? (up,down,left,right,cancel)");
        System.out.println(currentLocation.getPossibleMoves());
        String direction = sc.next();
        int moveId = -1;
        switch (direction) {
            case "up":
                moveId = currentLocation.checkNeighbors(currentLocation, 0);
                break;
            case "down":
                moveId = currentLocation.checkNeighbors(currentLocation, 1);
                break;
            case "left":
                moveId = currentLocation.checkNeighbors(currentLocation, 2);
                break;
            case "right":
                moveId = currentLocation.checkNeighbors(currentLocation, 3);
                break;
            case "cancel":
                return "You didn't move to any room";
            default:
                return "Invalid direction!";
        }
        if (moveId == -1) {
            return "You can't go in that direction!";
        } else {
            Player.getPlayer().changeHunger(2);
            Player.getPlayer().changeTiredness(1);
            if(Player.getPlayer().getTiredness() >= 100){
                Player.getPlayer().changeMoney(Player.getPlayer().getMoney()/2);
                Player.getPlayer().setTiredness(0);
                return "You fell asleep and got robbed!";
            } else {
                world.setCurrentPosition(moveId);
                switch(world.getCurrentPosition().getLocationType()){
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
                switch(world.getCurrentPosition().getName()){
                    case "Semine":
                        Music.setFileName("semine.wav");
                        break;
                    case "Kuttenberg":
                        Music.setFileName("kuttenberg.wav");
                        break;
                }
                for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
                    Player.getPlayer().getInventory().get(i).changeDurability(-1);
                }
                Music.play();
                return "You moved to: " + world.getName();
            }
        }
    }

    @Override
    public boolean exit() {
        if(Player.getPlayer().getHunger() >= 100){
            System.out.println("You starved to death");
            return true;
        }
        return false;
    }
}