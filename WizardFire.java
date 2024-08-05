import java.util.Random;

public class WizardFire extends Wizard {

    /**
     * コンストラクタ
     */
    public WizardFire(String backStory, int mp) {
        super("焔魔族の末裔。\n幼少期に両親を闇の勢力に奪われ、復讐の念に燃える。", mp); // 親クラスのコンストラクタを呼び出す
        this.normalAttackMpCost = 15; // 通常攻撃のMPコスト
        this.specialAttackMpCost = 40; // 必殺技のMPコスト
    }

    /**
     * 攻撃1
     */
    @Override
    public int attack1(Random random) {
        System.out.println(super.getName() + "は「漆黒の闇の炎【ダークフレイム・マスターストライク】」で攻撃した！");
        System.out.println("「漆黒の炎が、全てを飲み込み尽くす！この闇の力を思い知るがいい！」");

        int damage = random.nextInt(11) + 10; // 10-20ダメージ
        return damage;
    }

    /**
     * 攻撃2
     */
    @Override
    public int attack2(Random random) {
        System.out.println(super.getName() + "は「煉獄の業火（ピュリファイア）」で攻撃した！");
        System.out.println("「炎の剣が、君の全てを焼き尽くす！その熱さを感じるがいい！」");

        int damage = random.nextInt(11) + 20; // 20-30ダメージ
        return damage;// 攻撃力
    }

    /**
     * 攻撃3
     */
    @Override
    public int attack3(Random random) {
        System.out.println(super.getName() + "は「紅蓮の爆裂（クリムゾンデトネーション）」で攻撃した！");
        System.out.println("「炎の槍が、君の全てを焼き尽くす！その熱さを感じるがいい！」");

        int damage = random.nextInt(11) + 30; // 30-40ダメージ
        return damage;
    }

    /**
     * 特殊能力
     */
    @Override
    public int specialAbility(Random random, int targetHp) {
        System.out.println(super.getName() + "は「黒炎の絶対零度【ダークフレイム・アブソリュートゼロ】」を放った！");
        System.out.println("「この一撃で、君の命もこの世界の命運も、全てを燃やし尽くしてしまう！」");

        int damage = super.specialAbility(random, targetHp);
        return damage;// 攻撃力
    }
}
