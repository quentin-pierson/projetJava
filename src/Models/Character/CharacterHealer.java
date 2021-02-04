package Models.Character;

import Models.Armors.Armor;
import Models.Armors.ArmorCloth;
import Models.Armors.ArmorLeather;
import Models.Weapons.Weapon;
import Models.Weapons.WeaponBow;
import Models.Weapons.WeaponScepter;

public class CharacterHealer extends Character{

    private ArmorCloth armorCloth;
    private WeaponScepter weaponScepter;

    public CharacterHealer(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge, String name) {
        super(100, 20,1, 90, 10, 30, 100, 40, name);
    }

    @Override
    public Armor getEquipment() {
        return armorCloth;
    }

    @Override
    public Weapon getWeapon() {
        return weaponScepter;
    }

    @Override
    public String getTypeOfClass(){
        return "Healer";
    }

    @Override
    public void firstSpell(){

    }

    @Override
    public void secondSpell(){

    }

    @Override
    public void thirdSpell(){

    }
}
