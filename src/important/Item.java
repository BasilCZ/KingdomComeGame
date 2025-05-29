package important;

import enums.ItemType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Item {
    private int index;
    private String name;
    private String description;
    private int howMany;
    private ItemType type;
    private int durability;
    private int value;
    private boolean equippable;
    private static HashMap<Integer, Item> items = new HashMap<>();

    public Item(int index, String name, String description, int howMany, ItemType type, int durability, int value, boolean equippable) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.howMany = howMany;
        this.type = type;
        this.durability = durability;
        this.value = value;
        this.equippable = equippable;
    }

    public Item(int index, String name, String description, int durability, int value, boolean equippable) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.durability = durability;
        this.value = value;
        this.equippable = equippable;
    }



    public static boolean loadItems(){
        try (BufferedReader br = new BufferedReader(new FileReader("items.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Item item = new Item(
                        Integer.parseInt(lines[0]),
                        lines[1],
                        lines[2],
                        Integer.parseInt(lines[3]),
                        ItemType.valueOf(lines[4]),
                        Integer.parseInt(lines[5]),
                        Integer.parseInt(lines[6]),
                        Boolean.parseBoolean(lines[7])
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

    public void increaseHowMany(){
        this.howMany++;
    }

    public int getIndex() {
        return index;
    }

    public void decreaseDurability() {
        this.durability--;
    }
}
