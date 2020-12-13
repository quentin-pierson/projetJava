package Models;

public class Monsters extends Attributes{
    private MonsterType monsterType;
    private ClassType classType;

    public Monsters(int health, int armor, int level, int attack, int lucky, int mana, int dodge, MonsterType monsterType, ClassType classType) {
        super(health, armor, level, attack, lucky, mana, dodge);
        this.monsterType = monsterType;
        this.classType = classType;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public ClassType getClassType() {
        return classType;
    }


    public String toString() {
        return "Monsters{" +
                "monsterType=" + getMonsterType() +
                ", classType=" + getClassType() +
                '}';
    }
}
