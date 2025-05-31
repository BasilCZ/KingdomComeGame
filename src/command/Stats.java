package command;

import important.Player;

public class Stats extends Command{
    @Override
    public String execute() {
        Player p = Player.getPlayer();
        return "Hunger: " + p.getHunger() + "\nTiredness: " + p.getTiredness() + "\nStamina: " + p.getStamina() +  "\nMoney: " + p.getMoney() + "\nSpeech: " + p.getSpeech() + "\nCharisma: " + p.getCharisma();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
