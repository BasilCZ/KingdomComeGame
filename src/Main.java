import command.Console;
import enums.ArmorType;
import enums.WeaponType;
import important.*;
import loading_and_saving.LoadGame;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if(LoadGame.load()){
            Console c = new Console();
            c.start();
        } else {
            System.out.println("Error!");
        }
//        ArrayList<Item> items = new ArrayList<>();
//        Entity e = new Entity(0, "Enemy", 200, 200, 5, 5, items, 100, new Armor(0, "Test", "Test", 100, 150, true, ArmorType.HELMET, 10), new Armor(1, "ddgds", "gdgdsg", 1, 1, true, ArmorType.CHESTPLATE, 5), new Armor(2, "gdbsahjgd", "gnkjsdgbjg", 1, 1, true, ArmorType.LEGGINGS, 7), new Weapon(0, "fgdd", "fagd", 1, 1, true, WeaponType.SHORT_SWORD, 10, 10), 100);
//        Player p = new Player(200, 300, 10, 10, 100, new Armor(4, "fdg", "gddsg", 1, 1, true, ArmorType.HELMET, 10), new Armor(5, "fg", "ff", 1, 1, true, ArmorType.CHESTPLATE, 10), new Armor(6, "fsaga", "gkdg", 1, 1, true, ArmorType.LEGGINGS, 1), new Weapon(2, "gdsggdsh", "gsdgdgd", 1, 1, true, WeaponType.LONG_SWORD, 30, 20), 10, 10, 10, 10);
//        Battle.battle(e);
    }
}