package command;

import enums.LocationType;
import important.Player;
import world.WorldMap;

public class Sleep extends Command{
    /**
     * Lets the player sleep if they're near a motel.
     * @return <code>String</code> depending on the player's location
     */
    @Override
    public String execute() {
        WorldMap wm = new WorldMap();
        if(wm.getCurrentPosition().getLocationType() == LocationType.MOTEL){
            Player.getPlayer().setTiredness(0);
            Player.getPlayer().setHp(Player.getPlayer().getMaxHp());
            return "You went to sleep";
        }
        return "There's no motel here!";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
