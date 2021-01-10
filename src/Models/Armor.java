package Models;

public class Armor extends Abilities {
    private ArmorType armorType;

    private String name;
    private String description;

    private int durability;
    private int price;

    public Armor(int health, int armor, int level, int damage, int lucky, int mana, int dodge, ArmorType armorType, String name, String description, int durability, int price) {
        super(health, armor, level, damage, lucky, mana, dodge);
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
                ", attack='" + getDamage() +
                ", lucky='" + getLucky() +
                ", mana='" + getMana() +
                ", dodge='" + getDodge() +
                ", durability=" + durability +
                ", price=" + price +
                '}';
    }

}
