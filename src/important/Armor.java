package important;

import enums.ArmorType;

public class Armor extends Item{
    private ArmorType type;
    private int protection;

    public Armor(String name, String description, int howMany, int durability, int value, boolean equippable, ArmorType type, int protection) {
        super(name, description, howMany, durability, value, equippable);
        this.type = type;
        this.protection = protection;
    }
}
