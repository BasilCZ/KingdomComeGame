package command;

import enums.LocationType;
import important.Player;
import world.WorldMap;

public class Sleep extends Command{
    @Override
    public String execute() {
        WorldMap wm = new WorldMap();
        if(wm.getCurrentPosition().getLocationType() == LocationType.MOTEL){
            Player.getPlayer().setTiredness(0);
            return "You went to sleep";
        }
        return "There's no motel here!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
