package important;

public class Player extends Entity {

    private static Player player;
    private int hunger;
    private int tiredness;

    public Player() {
        super();
    }

    public static Player getPlayer(){
        return player;
    }

    public Player(int hp, int maxHp, int speech, int charisma, int stamina, Armor helmet, Armor chestplate, Armor leggings, Weapon weapon, int money, int hunger, int tiredness) {
        super(hp, maxHp, speech, charisma, stamina, helmet, chestplate, leggings, weapon, money);
        this.hunger = hunger;
        this.tiredness = tiredness;

        //ChatGPT
        player = this;
    }

    public static void setPlayer(Player player) {
        Player.player = player;
    }

    /**
     * Increases/Decreases player's hunger.
     * @param hunger how much.
     */
    public void changeHunger(int hunger) {
        if(this.hunger + hunger < 0){
            this.hunger = 0;
        } else {
            this.hunger += hunger;
        }
    }

    public int getHunger() {
        return hunger;
    }

    /**
     * Increases/Decreases player's tiredness.
     * @param tiredness how much.
     */
    public void changeTiredness(int tiredness) {
        if(this.tiredness + tiredness < 0){
            this.tiredness = 0;
        } else {
            this.tiredness += tiredness;
        }
    }

    public int getTiredness() {
        return tiredness;
    }

    public void setTiredness(int tiredness) {
        this.tiredness = tiredness;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }
}
