package Models.Character;

import Models.Armors.Armor;
import Models.Armors.ArmorCloth;
import Models.Armors.ArmorIron;
import Models.Weapons.Weapon;
import Models.Weapons.WeaponScepter;
import Models.Weapons.WeaponSword;

public class CharacterWizard extends Character{

    private ArmorCloth armorClothr;
    private WeaponScepter weaponScepter;


    public CharacterWizard(String name) {

        super(100, 10, 1, 90, 40, 30, 100, 20, name);
    }


    @Override
    public Armor getEquipment() {
        return armorClothr;
    }

    @Override
    public Weapon getWeapon() {
        return weaponScepter;
    }

    @Override
    public String getTypeOfClass(){
        return "Wizard";
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
