import java.util.Random;

public class WizardWater extends Wizard {

    /**
     * コンストラクタ
     */
    public WizardWater(String backStory, int mp) {
        super("水の精霊と契約を結び、不老不死の力を得た。\n過去の失われた愛を取り戻すために旅を続ける。\n", mp);
        this.normalAttackMpCost = 15; // 通常攻撃のMPコスト
        this.specialAttackMpCost = 40; // 必殺技のMPコスト
    }

    /**
     * 通常攻撃1
     */
    @Override
    public int attack1(Random random) {
        System.out.println(super.getName() + "は「氷結の裂帛【アイス・シャードスラスト】」で攻撃した！");
        System.out.println("「冷徹な氷の破片が、君の全てを貫く！その冷たさを心の奥まで感じるがいい！」");
        int damage = random.nextInt(11) + 10; // 10-20ダメージ
        return damage;// 攻撃力
    }

    /**
     * 通常攻撃2
     */
    @Override
    public int attack2(Random random) {
        System.out.println(super.getName() + "は「蒼海の槍（アクアスピア）で攻撃した！");
        System.out.println("「冷徹な氷の破片が、君の全てを貫く！その冷たさを心の奥まで感じるがいい！」");
        int damage = random.nextInt(11) + 20; // 20-30ダメージ
        return damage;// 攻撃力
    }

    /**
     * 通常攻撃3
     */
    @Override
    public int attack3(Random random) {
        System.out.println(super.getName() + "は「深淵の氷の裁き（アビスアイス・ジャッジメント）」で攻撃した！");
        System.out.println("「冷徹な氷の破片が、君の全てを貫く！その冷たさを心の奥まで感じるがいい！」");
        int damage = random.nextInt(11) + 30; // 30-40ダメージ
        return damage;// 攻撃力
    }

    /**
     * 特殊能力
     */
    @Override
    public int specialAbility(Random random, int targetHp) {
        System.out.println(super.getName() + "は「滅氷の大波（フローズン・カタクラズマ）」を放った！");
        System.out.println("「深淵の氷が全てを裁く時、君の運命も冷徹に決まる！凍りつく絶望を感じるがいい！」");
        int damage = super.specialAbility(random, targetHp);
        return damage;// 攻撃力
    }
}
