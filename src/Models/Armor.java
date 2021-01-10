package Models;

public class Armor extends Abilities {
    private ArmorType armorType;

    private String name;
    private String description;

    private int durability;
    private int price;

    public Armor(int health, int armor, int level, int attack, int lucky, int mana, int dodge, ArmorType armorType, String name, String description, int durability, int price, int damage, int levelUse) {
        super(health, armor, level, attack, lucky, mana, dodge);
        this.armorType = armorType;
        this.name = name;
        this.description = description;
        this.durability = durability;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Armors { " +
                "ArmorType=" + armorType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", health='" + getHealth() +
                ", armor='" + getArmor() +
                ", level='" + getLevel() +
                ", attack='" + getAttack() +
                ", lucky='" + getLucky() +
                ", mana='" + getMana() +
                ", dodge='" + getDodge() +
                ", durability=" + durability +
                ", price=" + price +
                '}';
    }

}
