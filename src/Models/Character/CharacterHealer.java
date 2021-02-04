package Models.Character;

public class CharacterHealer extends Character{
    public CharacterHealer(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge, String name) {
        super(100, 20,1, 90, 10, 30, 100, 40, name);
        spellName[0] = "1: Target health";
        spellName[1] = "2: Zone health";
        spellName[2] = "3: Punch";
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
