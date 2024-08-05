import java.util.Random;

public abstract class Wizard extends Object {

    private String name;
    private int hp;
    private int mp;
    private String backStory;
    protected int maxHp;
    protected int maxMp;
    protected int normalAttackMpCost;
    protected int specialAttackMpCost;

    /**
     * コンストラクタ
     */
    public Wizard(String backStory, int mp) {
        this.backStory = backStory;
        this.mp = mp;
        this.maxMp = mp;
    }

    /**
     * 名前を取得
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 名前を設定
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * HPを取得
     * 
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * HPを設定
     * 
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * MPを取得
     * 
     * @return mp
     */
    public int getMp() {
        return mp;
    }

    /**
     * MPを設定
     * 
     * @param mp
     */
    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getBackStory() {
        return this.backStory;
    }

    /**
     * 背景を設定
     * 
     * @param backstory
     */
    public void printBackstory() {
        System.out.println("\n∴‥∵‥∴‥∵‥∴‥∴‥∵‥∴‥∵‥∴‥∴‥∵‥∴‥∵‥∴‥∴‥∵‥∴");
        System.out.println("\n【" + this.name + "の背景】");
        System.out.println(this.backStory);
        System.out.println("∴‥∵‥∴‥∵‥∴‥∴‥∵‥∴‥∵‥∴‥∴‥∵‥∴‥∵‥∴‥∴‥∵‥∴\n");
    }

    /**
     * MPを消費
     * 
     * @param mpCost 消費MP
     * @return currentMp - mpCost
     */
    protected int consumeMp(int mpCost) {
        int currentMp = getMp(); // 現在のMPを取得
        setMp(currentMp - mpCost); // 攻撃によってMPを消費
        return currentMp - mpCost;
    }

    /**
     * ダメージを受ける
     * 
     * @param damage
     */
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    /**
     * 回復
     * 
     * @param random 乱数生成
     * @return healAmount 回復量
     */
    public int heal(Random random) {
        if (mp >= normalAttackMpCost) {
            if (hp < maxHp) {
                int healAmount = random.nextInt(20) + 10; // 10-30回復
                hp = Math.min(hp + healAmount, maxHp); // HPが最大値を超えないようにする
                mp -= normalAttackMpCost; // 回復によってMPを消費
                return healAmount; // 回復量を返す
            } else {
                System.out.println("HPが満タンです。");
                return 0;
            }
        } else {
            System.out.println("MPが足りないため、回復ができません。");
            return 0;
        }
    }

    /**
     * 攻撃
     * 
     * @param random   乱数生成
     * @param targetHp 相手のHP
     * @return targetHp
     */
    public int attack(Random random, int targetHp) {
        if (mp >= normalAttackMpCost) {
            mp -= normalAttackMpCost;
            int attackType = random.nextInt(3); // 0～2の乱数を生成
            switch (attackType) {
                case 0:
                    return attack1(random);
                case 1:
                    return attack2(random);
                case 2:
                    return attack3(random);
            }
        } else {
            System.out.println("MPが足りないため、通常攻撃ができません。");
        }
        return 0;
    }

    /**
     * 特殊能力
     * 
     * @param targetHp
     */
    public int specialAbility(Random random, int enemyHp) {
        if (mp >= specialAttackMpCost) {
            mp -= specialAttackMpCost;
            return random.nextInt(21) + 50; // 50-70ダメージ
        } else {
            System.out.println("MPが足りないため、特殊能力が使えません。");
        }
        return 0;
    }

    // 抽象メソッドとして宣言
    public abstract int attack1(Random random);

    public abstract int attack2(Random random);

    public abstract int attack3(Random random);

}
