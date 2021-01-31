package Models;

public class Weapon extends Abilities {
    private ListWeapon listWeapon;

    private String name;
    private String description;

    private int price;


    public Weapon(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge, ListWeapon listWeapon, String name, String description, int price) {
        super(health, armor, level, rateAttack, damage, lucky, mana, dodge);
        this.listWeapon = listWeapon;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    /*public Weapons(String health, String armor, String level, String attack, String lucky, String mana, String dodge,String listWeapon, String name, String description, String price) {
        super(Integer.parseInt(health), Integer.parseInt(armor), Integer.parseInt(level), Integer.parseInt(attack),
                Integer.parseInt(lucky), Integer.parseInt(mana), Integer.parseInt(dodge));
        this.listWeapon = ListWeapon.valueOf(listWeapon);
        this.name = name;
        this.description = description;
        this.price = Integer.parseInt(price);
    }*/

    @Override
    public String toString() {
        return "Weapons { " +
                "listWeapon=" + listWeapon +
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
