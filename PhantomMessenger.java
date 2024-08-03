public class PhantomMessenger extends Enemy {

    /**
     * コンストラクタ
     * @param name
     * @param hp
     * @param attackPower
     */
    public PhantomMessenger(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    /**
     * 攻撃
     */
    @Override
    public void attack(Wizard target) {
        System.out.println(name + " uses Phantom Strike!");
        target.takeDamage(attackPower);
    }

    /**
     * 特殊能力
     */
    @Override
    public void specialAbility(Wizard target) {
        System.out.println(name + " creates confusing illusions!");
        // 特別な能力の実装
    }
}
