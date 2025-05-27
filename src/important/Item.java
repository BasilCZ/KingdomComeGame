package important;

import enums.ItemType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Item {
    private String name;
    private String description;
    private int howMany;
    private ItemType type;
    private int durability;
    private int value;
    private static HashMap<Integer, Item> items = new HashMap<>();

    public Item(String name, String description, int howMany, ItemType type, int durability, int value) {
        this.name = name;
        this.description = description;
        this.howMany = howMany;
        this.type = type;
        this.durability = durability;
        this.value = value;
    }

    public Item(String name, String description, int howMany, int durability, int value) {
        this.name = name;
        this.description = description;
        this.howMany = howMany;
        this.durability = durability;
        this.value = value;
    }

    public boolean loadItems(){
        try (BufferedReader br = new BufferedReader(new FileReader("items.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                Item item = new Item(
                        lines[0],
                        lines[1],
                        Integer.parseInt(lines[2]),
                        ItemType.valueOf(lines[3]),
                        Integer.parseInt(lines[4]),
                        Integer.parseInt(lines[5])
                );
                items.put(Integer.parseInt(lines[0]), item);
            }
        } catch (IOException e) {
            return false;
        }
        return false;
    }
}
