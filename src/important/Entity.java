package important;

import java.util.ArrayList;

public class Entity {
    private int hp;
    private int maxHp;
    private int speech;
    private int charisma;
    private static ArrayList<Item> inventory = new ArrayList<>();
    private int stamina;

    public Entity() {

    }

    public Entity(int hp, int maxHp, int speech, int charisma, int stamina) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.speech = speech;
        this.charisma = charisma;
        this.stamina = stamina;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHp() {
        return hp;
    }
}
