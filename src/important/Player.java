package important;

public class Player extends Entity{
    private static Player player;
    private int hunger;
    private int sleepiness;
    private int drunkenness;

    public Player() {
        super();
    }

    public static Player getPlayer(){
        return player;
    }

    public Player(int hp, int maxHp, int speech, int charisma, int stamina, Armor helmet, Armor chestplate, Armor leggings, Weapon weapon, int money, int hunger, int sleepiness, int drunkenness) {
        super(hp, maxHp, speech, charisma, stamina, helmet, chestplate, leggings, weapon, money);
        this.hunger = hunger;
        this.sleepiness = sleepiness;
        this.drunkenness = drunkenness;

        player = this;
    }
}
