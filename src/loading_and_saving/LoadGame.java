package loading_and_saving;

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
        if(wm.loadMap()){
            if(new File("save.txt").exists()){
                try {
                    ObjectInputStream stream = new ObjectInputStream(new FileInputStream("save.txt"));
                    WorldMap.setWorld((HashMap<Integer, Location>) stream.readObject());
                    wm.setCurrentPosition(stream.readInt());
                    stream.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
