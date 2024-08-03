public abstract class Enemy extends Object {

    public String name;
    public int hp = 100;
    public int attackPower = 5;

    public abstract int attack(String wizardName, int attackPower, int targetHp);

    public abstract int specialAbility(String wizardName, int attackPower, int targetHp);

}