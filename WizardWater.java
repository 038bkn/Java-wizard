public class WizardWater extends Wizard {

    public WizardWater() {
        super();
    }

    @Override
    public int attack(int targetHp) {
        System.out.println(name + " uses Water Blast!");
        this.mp -= 10;  // 攻撃によってMPを消費
        return 25;      // 攻撃力（固定値または計算された値）
    }

    @Override
    public void specialAbility(int targetHp) {
        System.out.println(name + " uses Tsunami Wave!");
        this.mp -= 20;  // 特殊能力によってMPを消費
        // 特殊能力の実装
    }
}
