package command;

import enums.LocationType;
import world.WorldMap;

public class Shop extends Command{
    @Override
    public String execute() {
        WorldMap wm = new  WorldMap();
        if(wm.getCurrentPosition().getLocationType() == LocationType.CITY){
            return "Shop";
        } else {
            return "There isnt a shop nowhere near you";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
