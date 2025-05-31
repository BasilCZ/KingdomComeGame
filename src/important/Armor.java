package important;

import enums.ArmorType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Armor extends Item{
    private ArmorType type;
    private int protection;
    private static HashMap<Integer, Armor> armors = new HashMap<>();

    public Armor(int index, String name, String description, int durability, int value, boolean equippable, ArmorType type, int protection) {
        super(index, name, description, durability, value, equippable);
        this.type = type;
        this.protection = protection;
    }

    /**
     * Loads all the armors.
     * @return <code>true</code> if all the armors are loaded correctly, <code>false</code> otherwise
     */
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
                        Boolean.parseBoolean(lines[5]),
                        ArmorType.valueOf(lines[6]),
                        Integer.parseInt(lines[7])
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

    /**
     * Counts armor's protection depending on the armor's durability.
     * @return <code>int</code> how much protection
     */
    public int getProtection() {
        if(durability <= 20){
            if(protection - 2 >=0){
                return protection - 2;
            } else {
                return 0;
            }
        } else {
            return protection;
        }
    }

    @Override
    public String toString() {
        return "Armor{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", type=" + type +
                ", value=" + getValue() +
                ", durability=" + getDurability() +
                ", protection=" + protection +
                '}';
    }

    public ArmorType getArmorType() {
        return type;
    }
}
