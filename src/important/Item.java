package important;

import enums.ItemType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class Item implements Serializable {
    protected int index;
    protected String name;
    protected String description;
    private ItemType type;
    protected int durability;
    protected int value;
    protected boolean equippable;
    private int increaseHowMuch;
    private static HashMap<Integer, Item> items = new HashMap<>();

    public Item(int index, String name, String description, ItemType type, int durability, int value, boolean equippable, int increaseHowMuch) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.type = type;
        this.durability = durability;
        this.value = value;
        this.equippable = equippable;
        this.increaseHowMuch = increaseHowMuch;
    }

    public Item(int index, String name, String description, int durability, int value, boolean equippable) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.durability = durability;
        this.value = value;
        this.equippable = equippable;
    }


    /**
     * Loads all the items.
     * @return <code>true</code> if all the items are loaded correctly; <code>false</code> otherwise
     */
    public static boolean loadItems(){
        try (BufferedReader br = new BufferedReader(new FileReader("items.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Item item = new Item(
                        Integer.parseInt(lines[0]),
                        lines[1],
                        lines[2],
                        ItemType.valueOf(lines[3]),
                        Integer.parseInt(lines[4]),
                        Integer.parseInt(lines[5]),
                        Boolean.parseBoolean(lines[6]),
                        Integer.parseInt(lines[7])
                );
                items.put(Integer.parseInt(lines[0]), item);
            }
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static HashMap<Integer, Item> getItems() {
        return items;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", durability=" + durability +
                ", value=" + value +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ItemType getType() {
        return type;
    }

    public int getDurability() {
        return durability;
    }

    public int getValue() {
        return value;
    }

    public boolean isEquippable() {
        return equippable;
    }

    public int getIncreaseHowMuch() {
        return increaseHowMuch;
    }

    /**
     * Increases/Decreases the item's durability.
     * @param durability how much.
     */
    public void changeDurability(int durability) {
        if(this.durability + durability < 0) {
            this.durability = 0;
        }
        this.durability += durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
