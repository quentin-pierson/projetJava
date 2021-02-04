package Models.Weapons;

import Models.Abilities;

public class Weapon extends Abilities {

    private String name;
    private String description;

    private int price;


    public Weapon(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge, String name, String description, int price) {
        super(health, armor, level, rateAttack, damage, lucky, mana, dodge);
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Weapons { " +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", health=" + getHealth() +
                ", armor=" + getArmor() +
                ", level=" + getLevel() +
                ", attack=" + getDamage() +
                ", lucky=" + getLucky() +
                ", mana=" + getMana() +
                ", dodge=" + getDodge() +
                ", price=" + price +
                '}';
    }
}
