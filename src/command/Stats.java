package command;

import important.Player;

public class Stats extends Command{
    @Override
    public String execute() {
        Player p = Player.getPlayer();
        return "Hp: " + p.getHp() + "\nStamina: " + p.getStamina() + "\nHunger: " + p.getHunger() + "\nTiredness: " + p.getTiredness() + "\nMoney: " + p.getMoney() + "\nSpeech: " + p.getSpeech() + "\nCharisma: " + p.getCharisma();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
