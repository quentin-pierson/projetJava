package Models.Character;

public class CharacterWizard extends Character{
    public CharacterWizard(String name) {
        super(100, 10, 1, 90, 40, 30, 100, 20, name);
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
