package important;

public class Player extends Entity{
    private int hunger;
    private int sleepiness;
    private int drunkenness;

    public Player(int hp, int maxHp, int speech, int charisma, int stamina, int hunger, int sleepiness, int drunkenness) {
        super(hp, maxHp, speech, charisma, stamina);
        this.hunger = hunger;
        this.sleepiness = sleepiness;
        this.drunkenness = drunkenness;
    }

    public Player() {
        super();
    }

}
