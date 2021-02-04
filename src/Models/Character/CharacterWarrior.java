package Models.Character;

public class CharacterWarrior extends Character{
    public CharacterWarrior(String name) {
        super(100,40 , 1, 90,30, 10, 100, 20, name);
        spellName[0] = "1: Charge";
        spellName[1] = "2: Punch";
        spellName[2] = "3: Break Knee";
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
}
