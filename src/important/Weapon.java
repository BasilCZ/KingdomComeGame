package important;

import enums.WeaponType;

public class Weapon extends Item{
    private WeaponType type;
    private int damage;
    private int staminaCost;


    public Weapon(String name, String description, int howMany, int durability, int value, WeaponType type, int damage, int staminaCost) {
        super(name, description, howMany, durability, value);
        this.type = type;
        this.damage = damage;
        this.staminaCost = staminaCost;
    }
}
