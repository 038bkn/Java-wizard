public class WizardFire extends Wizard {

    /**
     * コンストラクタ
     */
    public WizardFire() {
        super(); // 親クラスのコンストラクタを呼び出す
    }

    /**
     * 攻撃1
     * @param targetHp 相手のHP
     * @return targetHp
     */
    @Override
    protected int attack1(int targetHp) {
        System.out.println(super.getName() + "は「漆黒の闇の炎【ダークフレイム・マスターストライク】」で攻撃した！");
        System.out.println("「漆黒の炎が、全てを飲み込み尽くす！この闇の力を思い知るがいい！」");

        consumeMp(10); // 攻撃によってMPを消費
        return 30;// 攻撃力
    }

    /**
     * 攻撃2
     * @param targetHp 相手のHP
     * @return targetHp
     */
    @Override
    protected int attack2(int targetHp) {
        System.out.println(super.getName() + "は「煉獄の業火（ピュリファイア）」で攻撃した！");
        System.out.println("「炎の剣が、君の全てを焼き尽くす！その熱さを感じるがいい！」");

        consumeMp(10); // 攻撃によってMPを消費
        return 25;// 攻撃力
    }

    /**
     * 攻撃3
     * @param targetHp 相手のHP
     * @return targetHp
     */
    @Override
    protected int attack3(int targetHp) {
        System.out.println(super.getName() + "は「紅蓮の爆裂（クリムゾンデトネーション）」で攻撃した！");
        System.out.println("「炎の槍が、君の全てを焼き尽くす！その熱さを感じるがいい！」");

        consumeMp(10); // 攻撃によってMPを消費
        return 30;// 攻撃力
    }

    /**
     * 特殊能力
     */
    @Override
    public int specialAbility(int targetHp) {
        System.out.println(super.getName() + "は「黒炎の絶対零度【ダークフレイム・アブソリュートゼロ】」を放った！");
        System.out.println("「この一撃で、君の命もこの世界の命運も、全てを燃やし尽くしてしまう！」");

        consumeMp(20); // 攻撃によってMPを消費
        return 40;// 攻撃力
    }
}
