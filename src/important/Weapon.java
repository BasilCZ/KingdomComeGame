package important;

import enums.WeaponType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Weapon extends Item{
    private WeaponType type;
    private int damage;
    private int staminaCost;
    private static HashMap<Integer, Weapon> weapons = new HashMap<>();

    public Weapon(int index, String name, String description, int durability, int value, boolean equippable, WeaponType type, int damage, int staminaCost) {
        super(index, name, description, durability, value, equippable);
        this.type = type;
        this.damage = damage;
        this.staminaCost = staminaCost;
    }

    public static boolean loadWeapons(){
        try(BufferedReader br = new BufferedReader(new FileReader("weapons.csv"))) {
            String line;
            while( (line = br.readLine()) != null){
                String[] lines = line.split(";");
                Weapon weapon = new Weapon(
                        Integer.parseInt(lines[0]),
                        lines[1],
                        lines[2],
                        Integer.parseInt(lines[3]),
                        Integer.parseInt(lines[4]),
                        Boolean.parseBoolean(lines[5]),
                        WeaponType.valueOf(lines[6]),
                        Integer.parseInt(lines[7]),
                        Integer.parseInt(lines[8])
                );
                weapons.put(Integer.parseInt(lines[0]), weapon);
            }
            return true;
        } catch (IOException e) {
            System.out.printf(e.getMessage());
            return false;
        }
    }

    public static HashMap<Integer, Weapon> getWeapons() {
        return weapons;
    }

    public int getDamage() {
        return damage;
    }

    public int getStaminaCost() {
        return staminaCost;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", type=" + type +
                ", durability=" + getDurability() +
                ", value=" + getValue() +
                ", damage=" + damage +
                ", staminaCost=" + staminaCost +
                '}';
    }
}
