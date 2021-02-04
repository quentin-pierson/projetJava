package Models.Character;

public class CharacterArcher extends Character{


    public CharacterArcher(String name) {
        super(100,20 , 1, 90, 30, 40, 100, 10, name);

        spellName[0] = "1: Bow shot";
        spellName[1] = "2: Bow multiple shot";
        spellName[2] = "3: Punch";
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
