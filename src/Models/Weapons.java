package Models;

public class Weapons extends Attributes{
    private WeaponType weaponType;

    private String name;
    private String description;

    private int price;


    public Weapons(int health, int armor, int level, int attack, int lucky, int mana, int dodge,WeaponType weaponType, String name, String description, int durability, int price, int damage, int levelUse) {
        super(health, armor, level, attack, lucky, mana, dodge);
        this.weaponType = weaponType;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Weapons { " +
                "weaponType=" + weaponType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", health='" + getHealth() +
                ", armor='" + getArmor() +
                ", level='" + getLevel() +
                ", attack='" + getAttack() +
                ", lucky='" + getLucky() +
                ", mana='" + getMana() +
                ", dodge='" + getDodge() +
                ", price=" + price +
                '}';
    }
}
