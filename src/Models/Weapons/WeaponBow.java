package Models.Weapons;

import Models.ListWeapon;

public class WeaponBow extends Weapon{

    public WeaponBow(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge, ListWeapon listWeapon, String name, String description, int price) {
        super(health, armor, level, rateAttack, damage, lucky, mana, dodge, listWeapon, name, description, price);
    }
}
