package Models.Character;

public class CharacterArcher extends Character{


    public CharacterArcher(int health, int armor, int level, int rateAttack, int damage, int lucky, int mana, int dodge, String name) {
        super(health, armor, level, rateAttack, damage, lucky, mana, dodge, name);
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
