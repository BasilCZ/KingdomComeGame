package command;

import important.Armor;
import important.Player;
import important.Weapon;

import java.util.Scanner;

public class Equip extends Command{
    /**
     * Equips a new armor/weapon.
     * @return whether you equipped an item or not
     */
    @Override
    public String execute() {
        System.out.println(new Inventory().execute());
        if(!Player.getPlayer().getInventory().isEmpty()) {
            System.out.println("What do you wanna equip?");
            Scanner sc = new Scanner(System.in);
            String name = sc.nextLine();
            for (int i = 0; i < Player.getPlayer().getInventory().size(); i++) {
                if (name.equalsIgnoreCase(Player.getPlayer().getInventory().get(i).getName()) && Player.getPlayer().getInventory().get(i).isEquippable()) {
                    if (Player.getPlayer().getInventory().get(i) instanceof Weapon) {
                        Player.getPlayer().setWeapon((Weapon) Player.getPlayer().getInventory().get(i));
                        return "You successfully equipped the weapon!";
                    }
                    if (Player.getPlayer().getInventory().get(i) instanceof Armor) {
                        Armor armor = (Armor) Player.getPlayer().getInventory().get(i);
                        switch (armor.getArmorType()) {
                            case HELMET -> Player.getPlayer().setHelmet(armor);
                            case CHESTPLATE -> Player.getPlayer().setChestplate(armor);
                            case LEGGINGS -> Player.getPlayer().setLeggings(armor);
                        }
                        return "You successfully equipped the armor!";
                    }
                }
            }
            return "Can't equip that";
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
