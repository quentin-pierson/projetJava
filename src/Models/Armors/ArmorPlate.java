package Models.Armors;

import Models.ArmorType;

public class ArmorPlate extends Armor{

    public ArmorPlate(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge, ArmorType armorType, String name, String description, int durability, int price) {
        super(health, armor, level, rateAttack, damage, lucky, mana, dodge, armorType, name, description, durability, price);
    }
}
