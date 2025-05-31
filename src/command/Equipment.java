package command;

import important.Player;

public class Equipment extends Command{
    @Override
    public String execute() {
        return "Helmet: " + Player.getPlayer().getHelmet()
                + "\nChestplate: " + Player.getPlayer().getChestplate()
                + "\nLeggings: " + Player.getPlayer().getLeggings()
                + "\nWeapon: " + Player.getPlayer().getWeapon();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
