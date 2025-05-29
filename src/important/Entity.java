package important;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Entity {
    private int index;
    private String name;
    private int hp;
    private int maxHp;
    private int speech;
    private int charisma;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int stamina;
    private Armor helmet;
    private Armor chestplate;
    private Armor leggings;
    private Weapon weapon;
    private static HashMap<Integer, Entity> entities = new HashMap<>();

    public Entity() {
    }

    public Entity(int hp, int maxHp, int speech, int charisma, int stamina, Armor helmet, Armor chestplate, Armor leggings, Weapon weapon) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.speech = speech;
        this.charisma = charisma;
        this.stamina = stamina;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.weapon = weapon;
    }

    public Entity(int index, String name, int hp, int maxHp, int speech, int charisma, ArrayList<Item> inventory, int stamina, Armor helmet, Armor chestplate, Armor leggings, Weapon weapon) {
        this.index = index;
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.speech = speech;
        this.charisma = charisma;
        this.inventory = inventory;
        this.stamina = stamina;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.weapon = weapon;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHp() {
        return hp;
    }

    public static boolean loadEntities(){
        try(BufferedReader br = new BufferedReader(new FileReader("entity.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                String[] intentoryLoad = lines[6].split(",");
                ArrayList<Item> items = new ArrayList<>();

                for (int i = 0; i < intentoryLoad.length; i++) {
                    items.add(Item.getItems().get(Integer.parseInt(intentoryLoad[i])));
                }
                Entity entity = new Entity(
                        Integer.parseInt(lines[0]),
                        lines[1],
                        Integer.parseInt(lines[2]),
                        Integer.parseInt(lines[3]),
                        Integer.parseInt(lines[4]),
                        Integer.parseInt(lines[5]),
                        items,
                        Integer.parseInt(lines[7]),
                        Armor.getArmors().get(Integer.parseInt(lines[8])),
                        Armor.getArmors().get(Integer.parseInt(lines[9])),
                        Armor.getArmors().get(Integer.parseInt(lines[10])),
                        Weapon.getWeapons().get(Integer.parseInt(lines[11]))
                );
                entities.put(Integer.parseInt(lines[0]), entity);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
