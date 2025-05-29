package important;

import enums.ArmorType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Armor extends Item{
    private ArmorType type;
    private int protection;
    private static HashMap<Integer, Armor> armors = new HashMap<>();

    public Armor(int index, String name, String description, int howMany, int durability, int value, boolean equippable, ArmorType type, int protection) {
        super(index, name, description, howMany, durability, value, equippable);
        this.type = type;
        this.protection = protection;
    }

    public static boolean loadArmor(){
        try(BufferedReader br = new BufferedReader(new FileReader("armor.csv"))){
            String line;
            while((line = br.readLine()) != null){
                String[] lines = line.split(";");
                Armor armor = new Armor(
                        Integer.parseInt(lines[0]),
                        lines[1],
                        lines[2],
                        Integer.parseInt(lines[3]),
                        Integer.parseInt(lines[4]),
                        Integer.parseInt(lines[5]),
                        Boolean.parseBoolean(lines[6]),
                        ArmorType.valueOf(lines[7]),
                        Integer.parseInt(lines[8])
                );
                armors.put(Integer.parseInt(lines[0]), armor);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static HashMap<Integer, Armor> getArmors() {
        return armors;
    }
}
