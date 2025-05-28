package command;

import world.Location;
import world.WorldMap;

import java.util.Scanner;

public class Move extends Command {

    private Scanner sc = new Scanner(System.in);
    private Location currentLocation = new Location();
    private WorldMap world = new WorldMap();

    //Moves player to a diffrent room according to the direction
    @Override
    public String execute() {
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
            //Checks if the door is locked or not
            if (world.getWorld().get(moveId).isLocked()) {
                return "The door is locked!";
            } else {
                world.setCurrentPosition(moveId);
                return "You moved to: " + world.getName();
            }
        }
    }

    @Override
    public boolean exit() {
        int currentId = world.getCurrentId();
        return currentId == 13;
    }
}