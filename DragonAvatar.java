public class DragonAvatar extends Enemy {

    /**
     * コンストラクタ
     * 
     * @param name
     * @param hp
     * @param attackPower
     */
    public DragonAvatar(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    /**
     * 攻撃手段1
     */
    @Override
    public int attack1(int target) {
        System.out.println(getName() + "は「炎の吐息（Flame Breath）」で攻撃した！");
        System.out.println("「灼熱の炎が、お前を焼き尽くす！」");

        return 30;
    }

    /**
     * 攻撃手段2
     */
    @Override
    public int attack2(int target) {
        System.out.println(getName() + "は「鱗の嵐（Scale Storm）」を使った！");
        System.out.println("「竜の鱗の嵐に、逃れる術はない！」");

        return 25;
    }

    /**
     * 攻撃手段3
     */
    @Override
    public int attack3(int target) {
        System.out.println(getName() + "は「竜神の怒り（Dragon God's Wrath）」で攻撃した！");
        System.out.println("「竜神の怒りを、今ここに解き放つ！」");

        return 30;
    }

    /**
     * 特殊能力
     */
    @Override
    public int specialAbility(Wizard target) {
        System.out.println(getName() + "は「竜炎の審判（Dragon's Judgement）」を放った！");
        System.out.println(" 「竜神の怒りが天を裂く！お前の運命もここで終わる！」");

        return 40;
    }
}
