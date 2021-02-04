package Models.Character;

import Models.Armors.Armor;
import Models.Armors.ArmorCloth;
import Models.Armors.ArmorLeather;
import Models.Weapons.Weapon;
import Models.Weapons.WeaponBow;
import Models.Weapons.WeaponScepter;
import Services.DataServices;

public class CharacterHealer extends Character{

    private ArmorCloth armorCloth;
    private WeaponScepter weaponScepter;

    public CharacterHealer(String name) {
        super(100, 20,1, 90, 10, 30, 100, 40, name);
        spellName[0] = "1: Target health";
        spellName[1] = "2: Zone health";
        spellName[2] = "3: Punch";
        weaponScepter = DataServices.getInstance().getWeaponScepter(0);
        armorCloth = DataServices.getInstance().getArmorCloth(0);
    }

    public CharacterHealer(int health,int armor,int level,int rateAttack , int damage,int lucky ,int mana, int dodge,String name){
        super(health,armor , level, rateAttack,damage, lucky, mana, dodge, name);
        weaponScepter = DataServices.getInstance().getWeaponScepter(0);
        armorCloth = DataServices.getInstance().getArmorCloth(0);
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

    @Override
    public void setWeapon(Weapon weapon) {
        this.weaponScepter = (WeaponScepter) weapon;
    }

    @Override
    public void setArmor(Armor armor) {
        this.armorCloth = (ArmorCloth) armor;
    }
}
