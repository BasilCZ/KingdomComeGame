package loading_and_saving;

import important.*;
import world.Location;
import world.WorldMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class LoadGame {
    public static boolean load(){
        WorldMap wm = new WorldMap();
        if(WorldMap.loadMap() && Item.loadItems() && Weapon.loadWeapons() && Armor.loadArmor() /*&& Entity.loadEntities()*/){
            if(new File("save.txt").exists()){
                try {
                    ObjectInputStream stream = new ObjectInputStream(new FileInputStream("save.txt"));
                    WorldMap.setWorld((HashMap<Integer, Location>) stream.readObject());
                    wm.setCurrentPosition(stream.readInt());
                    Player.setPlayer((Player) stream.readObject());
                    stream.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            } else {
                Player p = new Player();
            }
            return true;
        } else {
            return false;
        }
    }
}
