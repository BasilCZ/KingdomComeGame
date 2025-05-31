package important;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Entity implements Serializable {
    protected int index;
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int speech;
    protected int charisma;
    protected ArrayList<Item> inventory = new ArrayList<>();
    protected int stamina;
    protected Armor helmet;
    protected Armor chestplate;
    protected Armor leggings;
    protected Weapon weapon;
    protected int money;
    private static HashMap<Integer, Entity> entities = new HashMap<>();
    private int where;
    private boolean inTrosky;
    private boolean isAlive;
    private boolean gaveMoney;
    private boolean gaveItem;

    public Entity() {
    }

    public Entity(int hp, int maxHp, int speech, int charisma, int stamina, Armor helmet, Armor chestplate, Armor leggings, Weapon weapon, int money) {
        this.hp = hp;
        this.maxHp = maxHp;
        this.speech = speech;
        this.charisma = charisma;
        this.stamina = stamina;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.weapon = weapon;
        this.money = money;
    }

    public Entity(int index, String name, int hp, int maxHp, int speech, int charisma, ArrayList<Item> inventory, int stamina, Armor helmet, Armor chestplate, Armor leggings, Weapon weapon, int money, int where, boolean inTrosky, boolean isAlive, boolean gaveMoney, boolean gaveItem) {
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
        this.money = money;
        this.where = where;
        this.inTrosky = inTrosky;
        this.isAlive = isAlive;
        this.gaveMoney = gaveMoney;
        this.gaveItem = gaveItem;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public int getHp() {
        return hp;
    }

    /**
     * Counts the attacker's damage to the defender.
     * @param howMuch the attacker's damage.
     * @param armor the defender's armor.
     * @param bonusProtection bonus protection if the defender is blocking.
     * @return <code>int</code> how much damage the attacker did to the defender
     */
    public int attack(int howMuch, Armor armor, int bonusProtection){
        int damage = (howMuch - (armor.getProtection() + bonusProtection));
        if(damage > 0){
            if(stamina - damage < 0){
                stamina = 0;
                this.hp += (stamina - damage);
            } else if (stamina - damage > 0) {
                stamina -= damage;
                this.hp -= damage/10;
            }
            if(hp < 0){
                hp = 0;
            }
        } else {
            damage = 0;
        }
        return damage;
    }

    /**
     * Loads all the entities.
     * @return <code>true</code> if all the entities are loaded correctly; <code>false</code> otherwise
     */
    public static boolean loadEntities(){
        try(BufferedReader br = new BufferedReader(new FileReader("entity.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                String[] intentoryLoad = lines[6].split(",");
                ArrayList<Item> items = new ArrayList<>();

                if(!lines[6].isBlank()) {
                    for (int i = 0; i < intentoryLoad.length; i++) {
                        items.add(Item.getItems().get(Integer.parseInt(intentoryLoad[i])));
                    }
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
                        Weapon.getWeapons().get(Integer.parseInt(lines[11])),
                        Integer.parseInt(lines[12]),
                        Integer.parseInt(lines[13]),
                        Boolean.parseBoolean(lines[14]),
                        Boolean.parseBoolean(lines[15]),
                        Boolean.parseBoolean(lines[16]),
                        Boolean.parseBoolean(lines[17])
                );
                entities.put(Integer.parseInt(lines[0]), entity);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Armor getHelmet() {
        return helmet;
    }

    public Armor getChestplate() {
        return chestplate;
    }

    public Armor getLeggings() {
        return leggings;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getStamina() {
        return stamina;
    }

    public String getName() {
        return name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Increases/Decreases entity's stamina.
     * @param stamina how much.
     */
    public void changeStamina(int stamina) {
        if(this.stamina + stamina > 200){
            this.stamina = 200;
        } else  if (this.stamina + stamina < 0){
            this.stamina = 0;
        } else {
            this.stamina += stamina;
        }
    }

    public int getMoney() {
        return money;
    }

    public void changeMoney(int money) {
        this.money += money;
    }

    public void addToInventory(Item item){
        inventory.add(item);
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setLeggings(Armor leggings) {
        this.leggings = leggings;
    }

    public void setChestplate(Armor chestplate) {
        this.chestplate = chestplate;
    }

    public void setHelmet(Armor helmet) {
        this.helmet = helmet;
    }

    public void changeSpeech(int speech) {
        this.speech += speech;
    }

    public void changeCharisma(int charisma) {
        this.charisma += charisma;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public static HashMap<Integer, Entity> getEntities() {
        return entities;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public int getWhere() {
        return where;
    }

    /**
     * Increases/Decreases entity's hp
     * @param hp how much.
     */
    public void changeHp(int hp) {
        if(this.hp + hp > maxHp){
            this.hp = maxHp;
        } else if(this.hp + hp < maxHp) {
            this.hp = 0;
        } else {
            this.hp += hp;
        }
    }

    public int getSpeech() {
        return speech;
    }

    public int getCharisma() {
        return charisma;
    }

    public static void setEntities(HashMap<Integer, Entity> entities) {
        Entity.entities = entities;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "index=" + index +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", maxHp=" + maxHp +
                ", speech=" + speech +
                ", charisma=" + charisma +
                ", inventory=" + inventory +
                ", stamina=" + stamina +
                ", helmet=" + helmet +
                ", chestplate=" + chestplate +
                ", leggings=" + leggings +
                ", weapon=" + weapon +
                ", money=" + money +
                ", where=" + where +
                ", inTrosky=" + inTrosky +
                ", isAlive=" + isAlive +
                '}';
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public boolean isGaveMoney() {
        return gaveMoney;
    }

    public void setGaveMoney(boolean gaveMoney) {
        this.gaveMoney = gaveMoney;
    }

    public boolean isGaveItem() {
        return gaveItem;
    }

    public void setGaveItem(boolean gaveItem) {
        this.gaveItem = gaveItem;
    }
}
