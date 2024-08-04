import java.util.Random;

public class WizardWater extends Wizard {

    /**
     * コンストラクタ
     */
    public WizardWater() {
        super();
    }

    @Override
    protected int attack1(int targetHp) {
        System.out.println(super.getName() + "は「氷結の裂帛【アイス・シャードスラスト】」で攻撃した！");
        System.out.println("「冷徹な氷の破片が、君の全てを貫く！その冷たさを心の奥まで感じるがいい！」");
        consumeMp(10); // 攻撃によってMPを消費
        return 30;// 攻撃力
    }

    @Override
    protected int attack2(int targetHp) {
        System.out.println(super.getName() + "は「蒼海の槍（アクアスピア）で攻撃した！");
        System.out.println("「冷徹な氷の破片が、君の全てを貫く！その冷たさを心の奥まで感じるがいい！」");
        consumeMp(10); // 攻撃によってMPを消費
        return 25;// 攻撃力
    }

    @Override
    protected int attack3(int targetHp) {
        System.out.println(super.getName() + "は「深淵の氷の裁き（アビスアイス・ジャッジメント）」で攻撃した！");
        System.out.println("「冷徹な氷の破片が、君の全てを貫く！その冷たさを心の奥まで感じるがいい！」");
        consumeMp(10); // 攻撃によってMPを消費
        return 30;// 攻撃力
    }

    /**
     * 特殊能力
     */
    @Override
    public int specialAbility(int targetHp) {
        System.out.println(super.getName() + " uses Tsunami Wave!");
        System.out.println("深淵の氷が全てを裁く時、君の運命も冷徹に決まる！凍りつく絶望を感じるがいい！");
        consumeMp(20); // 攻撃によってMPを消費
        return 40;// 攻撃力
    }
}
