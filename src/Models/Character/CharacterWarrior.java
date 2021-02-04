package Models.Character;

import Models.Armors.Armor;
import Models.Armors.ArmorCloth;
import Models.Armors.ArmorIron;
import Models.Armors.ArmorLeather;
import Models.Weapons.Weapon;
import Models.Weapons.WeaponBow;
import Models.Weapons.WeaponScepter;
import Models.Weapons.WeaponSword;
import Services.CSVServices;
import Services.DataServices;

public class CharacterWarrior extends Character{

    private ArmorIron armorIron;
    private WeaponSword weaponSword;


    public CharacterWarrior(String name) {
        super(100,40 , 1, 90,30, 10, 100, 20, name);
        spellName[0] = "1: Charge";
        spellName[1] = "2: Punch";
        spellName[2] = "3: Break Knee";
        weaponSword = DataServices.getInstance().getWeaponSword(0);
        armorIron = DataServices.getInstance().getArmorIron(0);
    }

    public CharacterWarrior(int health,int armor,int level,int rateAttack , int damage,int lucky ,int mana, int dodge,String name){
        super(health,armor , level, rateAttack,damage, lucky, mana, dodge, name);
        weaponSword = DataServices.getInstance().getWeaponSword(0);
        armorIron = DataServices.getInstance().getArmorIron(0);
    }

    @Override
    public Armor getEquipment() {
        return armorIron;
    }

    @Override
    public Weapon getWeapon() {
        return weaponSword;
    }

    @Override
    public String getTypeOfClass(){
        return "Warrior";
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

    @Override
    public void setWeapon(Weapon weapon) {
        this.weaponSword = (WeaponSword) weapon;
    }

    @Override
    public void setArmor(Armor armor) {
        this.armorIron = (ArmorIron) armor;
    }
}
