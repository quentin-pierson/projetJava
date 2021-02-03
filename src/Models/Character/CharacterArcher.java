package Models.Character;

public class CharacterArcher extends Character{


    public CharacterArcher(String name) {
        super(100,20 , 1, 90, 30, 40, 100, 10, name);
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
