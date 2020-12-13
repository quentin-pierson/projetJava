package Models;

public class Players extends Attributes{

    private String name;
    private float experience;
    private ClassType classType;
    private int gold;
    private int pointOpen;
    private Weapons weapons;

    public Players(int health, int armor, int level, int attack, int lucky, int mana, int dodge, String name, float experience, ClassType classType,int gold) {
        super(health, armor, level, attack, lucky, mana, dodge);
        this.name = name;
        this.experience = experience;
        this.classType = classType;
        this.gold=gold;
    }

    public String getName(){
        return name;
    }

    public ClassType getClassType(){
        return classType;
    }
}
