package Models.Character;


import Models.Armors.Armor;
import Models.Armors.ArmorLeather;
import Models.Weapons.Weapon;
import Models.Weapons.WeaponBow;

public class CharacterArcher extends Character{
    private ArmorLeather armorLeather;
    private WeaponBow weaponBow;

    public CharacterArcher(String name) {
        super(100,20 , 1, 90, 30, 40, 100, 10, name);
    }

    @Override
    public Armor getEquipment() {
        return armorLeather;
    }

    @Override
    public Weapon getWeapon() {
        return weaponBow;
    }

    @Override
    public String getTypeOfClass(){
        return "Archer";
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
