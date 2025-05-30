package loading_and_saving;

import important.*;
import world.WorldMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class LoadGame {
    /**
     * Loads all the important objects.
     * @return <code>true</code> if everything is loaded correctly; <code>false</code> otherwise
     */
    public static boolean load(){
        WorldMap wm = new WorldMap();
        Music.setFileName("other.wav");
        Music.initialize();
        Music.play();
        if(WorldMap.loadMap() && Item.loadItems() && Weapon.loadWeapons() && Armor.loadArmor() && Entity.loadEntities()){
            if(new File("save.txt").exists()){
                try {
                    ObjectInputStream stream = new ObjectInputStream(new FileInputStream("save.txt"));
                    wm.setCurrentPosition(stream.readInt());
                    Player.setPlayer((Player) stream.readObject());
                    Entity.setEntities((HashMap<Integer, Entity>) stream.readObject());
                    stream.close();
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            } else {
                Armor helmet = Armor.getArmors().get(0);
                Armor chestplate = Armor.getArmors().get(11);
                Armor leggings = Armor.getArmors().get(3);
                Weapon weapon = Weapon.getWeapons().get(10);
                Player p = new Player(100,100,2,2,200,helmet, chestplate, leggings, weapon, 20, 0, 0);
                Player.getPlayer().addToInventory(helmet);
                Player.getPlayer().addToInventory(chestplate);
                Player.getPlayer().addToInventory(leggings);
                Player.getPlayer().addToInventory(weapon);
                Player.getPlayer().addToInventory(Item.getItems().get(6));
                Player.getPlayer().addToInventory(Item.getItems().get(5));
                Player.getPlayer().addToInventory(Item.getItems().get(1));
                Player.getPlayer().addToInventory(Item.getItems().get(0));
                Player.getPlayer().addToInventory(Item.getItems().get(18));
            }
            return true;
        } else {
            return false;
        }
    }
}
