public class DragonAvatar extends Enemy {

    /**
     * コンストラクタ
     * @param name
     * @param hp
     * @param attackPower
     */
    public DragonAvatar(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    /**
     * 攻撃
     */
    @Override
    public void attack(Wizard target) {
        System.out.println(name + " uses Dragon Breath!");
        target.takeDamage(attackPower);
    }

    /**
     * 特殊能力
     */
    @Override
    public void specialAbility(Wizard target) {
        System.out.println(name + " unleashes a powerful roar!");
        // 特別な能力の実装
    }
}
