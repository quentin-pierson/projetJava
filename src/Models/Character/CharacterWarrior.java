package Models.Character;

public class CharacterWarrior extends Character{
    public CharacterWarrior(String name) {
        super(100,40 , 1, 90,30, 10, 100, 20, name);

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
