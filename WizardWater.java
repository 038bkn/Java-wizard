public class WizardWater extends Wizard {

    /**
     * コンストラクタ
     */
    public WizardWater() {
        super();
    }

    /**
     * 攻撃
     */
    @Override
    public int attack(int targetHp) {
        System.out.println(name + "は「氷結の裂帛【アイス・シャードスラスト】」で攻撃した！");
        System.out.println("「冷徹な氷の破片が、君の全てを貫く！その冷たさを心の奥まで感じるがいい！」");
        this.mp -= 10;  // 攻撃によってMPを消費
        return 25;      // 攻撃力（固定値または計算された値）
    }

    /**
     * 特殊能力
     */
    @Override
    public void specialAbility(int targetHp) {
        System.out.println(name + " uses Tsunami Wave!");
        System.out.println("深淵の氷が全てを裁く時、君の運命も冷徹に決まる！凍りつく絶望を感じるがいい！");
        this.mp -= 20;  // 特殊能力によってMPを消費
        // 特殊能力の実装
    }
}
