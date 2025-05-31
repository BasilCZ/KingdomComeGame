package command;

import enums.LocationType;
import world.WorldMap;

public class Travel extends Command{
    @Override
    public String execute() {
        WorldMap wm = new WorldMap();
        if(wm.getCurrentPosition().getLocationType() == LocationType.OTHER){
            if(wm.getCurrentId() == 7){
                wm.goToKuttenberg();
                return "You traveled to Kuttenberg!";
            } else {
                wm.goToTrosky();
                return "You traveled to Trosky!";
            }
        } else {
            return "You cant travel from here!";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
