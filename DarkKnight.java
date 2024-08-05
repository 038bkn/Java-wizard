public class DarkKnight extends Enemy {

    /**
     * コンストラクタ
     * @param name
     * @param hp
     * @param attackPower
     */
    public DarkKnight(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    /**
     * 攻撃手段1
     */
    @Override
    public int attack1(int target) {
        System.out.println(getName() + "は「闇の一閃（Dark Slash）」で攻撃した！");
        System.out.println("「闇の力が、君の全てを蝕む！その鋭さを感じるがいい！」");

        return 30;
    }

    /**
     * 攻撃手段2
     */
    @Override
    public int attack2(int target) {
        System.out.println(getName() + "は「影の突撃（Shadow Charge）」を使った！");
        System.out.println("「影のごとく、瞬く間にお前を貫く！」");

        return 25;
    }

    /**
     * 攻撃手段3
     */
    @Override
    public int attack3(int target) {
        System.out.println(getName() + "は「魔黒の剣舞（Cursed Blade Dance）」で攻撃した！");
        System.out.println("「この剣の舞に抗える者は存在しない！」");

        return 30;
    }

    /**
     * 特殊能力
     */
    @Override
    public int specialAbility(Wizard target) {
        System.out.println(getName() + "は「漆黒の終焉（Eternal Darkness）」を放った！");
        System.out.println(" 「漆黒の闇が全てを飲み込む！これで終わりだ！」");

        return 40;
    }
}
