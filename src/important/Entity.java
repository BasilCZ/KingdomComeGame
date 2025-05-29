package important;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Entity {
    private int index;
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
    private HashMap<Integer, Entity> entities = new HashMap<>();

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

    public Entity(int index, int hp, int maxHp, int speech, int charisma, int stamina, Armor helmet, Armor chestplate, Armor leggings, Weapon weapon, HashMap<Integer, Entity> entities) {
        this.index = index;
        this.hp = hp;
        this.maxHp = maxHp;
        this.speech = speech;
        this.charisma = charisma;
        this.stamina = stamina;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.weapon = weapon;
        this.entities = entities;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHp() {
        return hp;
    }

    public boolean loadEntities(){
        try(BufferedReader br = new BufferedReader(new FileReader("entity.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
