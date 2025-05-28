package loading_and_saving;

import world.WorldMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Load {
    public static boolean load(){
        WorldMap wm = new WorldMap();
        if(wm.loadMap()){
            if(new File("save.txt").exists()){
                try {
                    ObjectInputStream stream = new ObjectInputStream(new FileInputStream("save.txt"));
                    //Add loading
                    stream.close();
                } catch (IOException e) {
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
