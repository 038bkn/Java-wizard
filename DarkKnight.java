public class DarkKnight extends Enemy {

    public DarkKnight(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    @Override
    public void attack(Wizard target) {
        System.out.println(name + " uses Dark Slash!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialAbility() {
        System.out.println(name + " envelops the area in darkness!");
        // 特別な能力の実装
    }
}
