public class DragonAvatar extends Enemy {

    public DragonAvatar(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    @Override
    public void attack(Wizard target) {
        System.out.println(name + " uses Dragon Breath!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialAbility() {
        System.out.println(name + " unleashes a powerful roar!");
        // 特別な能力の実装
    }
}
