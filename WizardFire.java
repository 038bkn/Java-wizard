public class WizardFire extends Wizard {

    /**
     * コンストラクタ
     */
    public WizardFire() {
        super();
    }

    /**
     * 攻撃
     */
    @Override
    public int attack(int targetHp) {
        System.out.println(name + "は「漆黒の闇の炎【ダークフレイム・マスターストライク】」で攻撃した！");
        System.out.println("「漆黒の炎が、全てを飲み込み尽くす！この闇の力を思い知るがいい！」");
        this.mp -= 10; // 攻撃によってMPを消費
        return 30; // 攻撃力（固定値または計算された値）
    }

    /**
     * 特殊能力
     */
    @Override
    public void specialAbility(int targetHp) {
        System.out.println(name + "は「黒炎の絶対零度【ダークフレイム・アブソリュートゼロ】」を放った！");
        System.out.println("「この一撃で、君の命もこの世界の命運も、全てを燃やし尽くしてしまう！」");
        this.mp -= 20; // 特殊能力によってMPを消費
    }
}
