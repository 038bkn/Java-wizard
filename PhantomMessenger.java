public class PhantomMessenger extends Enemy {

    /**
     * コンストラクタ
     * 
     * @param name
     * @param hp
     * @param attackPower
     */
    public PhantomMessenger(String name, int hp, int attackPower) {
        super(name, hp, attackPower);
    }

    /**
     * 攻撃手段1
     */
    @Override
    public int attack1(int target) {
        System.out.println(getName() + "は「幻影の刃（Phantom Blade）」で攻撃した！");
        System.out.println("「幻影の刃が、お前の命を奪う！」");

        return 30;
    }

    /**
     * 攻撃手段2
     */
    @Override
    public int attack2(int target) {
        System.out.println(getName() + "は「霧の抱擁（Embrace of Mist）」を使った！");
        System.out.println("「霧の中に消えるがいい、お前の運命も共に！」");

        return 25;
    }

    /**
     * 攻撃手段3
     */
    @Override
    public int attack3(int target) {
        System.out.println(getName() + "は「亡霊の囁き（Whisper of the Dead）」で攻撃した！");
        System.out.println("「亡霊の囁きが、お前の心を狂わせる！」");

        return 30;
    }

    /**
     * 特殊能力
     */
    @Override
    public int specialAbility(Wizard target) {
        System.out.println(getName() + "は「虚空の断罪（Void Punishment）」を放った！");
        System.out.println(" 「虚空の闇が全てを包み込む！お前の存在も消え去る！」");

        return 40;
    }
}