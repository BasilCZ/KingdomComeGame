package important;

import enums.ArmorType;

public class Armor extends Item{
    private ArmorType type;
    private int protection;


    public Armor(String name, String description, int howMany, int durability, int value, ArmorType type, int protection) {
        super(name, description, howMany, durability, value);
        this.type = type;
        this.protection = protection;
    }
}
