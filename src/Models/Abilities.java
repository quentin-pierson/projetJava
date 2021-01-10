package Models;

public class Abilities {

    private int health;
    private int armor;
    private int level;

    private int attack;
    private int damage;
    private int lucky;
    private int mana;
    private int dodge;

    public Abilities(int health, int armor, int level, int attack, int damage, int lucky, int mana, int dodge) {
        this.health = health;
        this.armor = armor;
        this.level = level;
        this.attack = attack;
        this.damage = damage;
        this.lucky = lucky;
        this.mana = mana;
        this.dodge = dodge;
    }

    public int getHealth() {
        return health;
    }

    public int getArmor() {
        return armor;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDamage() { return damage; }

    public int getLucky() {
        return lucky;
    }

    public int getMana() {
        return mana;
    }

    public int getDodge() {
        return dodge;
    }
}
