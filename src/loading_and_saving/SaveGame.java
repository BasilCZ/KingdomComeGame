package loading_and_saving;

import important.Entity;
import important.Player;
import world.WorldMap;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveGame {
    public static boolean save(){
        WorldMap wm = new WorldMap();
        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("save.txt"));
            stream.writeInt(wm.getCurrentId());
            stream.writeObject(Player.getPlayer());
            stream.writeObject(Entity.getEntities());

            stream.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
