package Models.Character;


import Models.Armors.Armor;
import Models.Armors.ArmorLeather;
import Models.Weapons.Weapon;
import Models.Weapons.WeaponBow;
import Services.DataServices;

public class CharacterArcher extends Character{
    private ArmorLeather armorLeather;
    private WeaponBow weaponBow;

    public CharacterArcher(String name) {
        super(100,20 , 1, 90, 30, 40, 100, 10, name);

        spellName[0] = "1: Bow shot";
        spellName[1] = "2: Bow multiple shot";
        spellName[2] = "3: Punch";
        weaponBow = DataServices.getInstance().getWeaponBow(0);
        armorLeather = DataServices.getInstance().getArmorLeather(0);
    }

    public CharacterArcher(int health,int armor,int level,int rateAttack , int damage,int lucky ,int mana, int dodge,String name){
        super(health,armor , level, rateAttack,damage, lucky, mana, dodge, name);
        weaponBow = DataServices.getInstance().getWeaponBow(0);
        armorLeather = DataServices.getInstance().getArmorLeather(0);
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

    @Override
    public void setWeapon(Weapon weapon) {
        this.weaponBow = (WeaponBow) weapon;
    }

    @Override
    public void setArmor(Armor armor) {
        this.armorLeather = (ArmorLeather) armor;
    }
}
