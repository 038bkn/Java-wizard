public class PhantomMessenger extends Enemy {

    public PhantomMessenger(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    @Override
    public void attack(Wizard target) {
        System.out.println(name + " uses Phantom Strike!");
        target.takeDamage(attackPower);
    }

    @Override
    public void specialAbility() {
        System.out.println(name + " creates confusing illusions!");
        // 特別な能力の実装
    }
}
