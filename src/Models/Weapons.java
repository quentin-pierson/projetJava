package Models;

public class Weapons {
    private WeaponType weaponType;

    private String name;
    private String description;

    private int durability;
    private int price;
    private int damage;

    private int levelUse; // level necessary for used weapons

    public Weapons(WeaponType weaponType, String name, String description, int durability, int price, int damage, int levelUse) {
        this.weaponType = weaponType;
        this.name = name;
        this.description = description;
        this.durability = durability;
        this.price = price;
        this.damage = damage;
        this.levelUse = levelUse;
    }

    @Override
    public String toString() {
        return "Weapons { " +
                "weaponType=" + weaponType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", durability=" + durability +
                ", price=" + price +
                ", damage=" + damage +
                ", levelUse=" + levelUse +
                '}';
    }
}
