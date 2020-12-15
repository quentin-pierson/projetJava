package Models;

public class Weapons extends Attributes{
    private WeaponType weaponType;

    private String name;
    private String description;

    private int price;


    public Weapons(int health, int armor, int level, int attack, int lucky, int mana, int dodge,WeaponType weaponType, String name, String description, int price) {
        super(health, armor, level, attack, lucky, mana, dodge);
        this.weaponType = weaponType;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /*public Weapons(String health, String armor, String level, String attack, String lucky, String mana, String dodge,String weaponType, String name, String description, String price) {
        super(Integer.parseInt(health), Integer.parseInt(armor), Integer.parseInt(level), Integer.parseInt(attack),
                Integer.parseInt(lucky), Integer.parseInt(mana), Integer.parseInt(dodge));
        this.weaponType = WeaponType.valueOf(weaponType);
        this.name = name;
        this.description = description;
        this.price = Integer.parseInt(price);
    }*/

    @Override
    public String toString() {
        return "Weapons { " +
                "weaponType=" + weaponType +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", health=" + getHealth() +
                ", armor=" + getArmor() +
                ", level=" + getLevel() +
                ", attack=" + getAttack() +
                ", lucky=" + getLucky() +
                ", mana=" + getMana() +
                ", dodge=" + getDodge() +
                ", price=" + price +
                '}';
    }
}
