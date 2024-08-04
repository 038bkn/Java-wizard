import java.util.Random;

public abstract class Wizard extends Object {

    private String name;
    private int hp;
    private int mp;
    public int maxHp;

    /**
     * コンストラクタ
     */
    public Wizard() {
        super(); // 親クラスのコンストラクタを呼び出す
        this.hp = 100; // 基本的なHP
        this.mp = 50; // 基本的なMP
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

    /**
     * MPを消費
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
     */
    public int heal() {
        if (this.hp == this.maxHp) { // HPが満タンの場合
            return 0; // 回復しないため0を返す
        }
        int healAmount = 20; // 回復量を設定
        System.out.println("回復しちゃお！");
        this.hp = Math.min(this.hp + healAmount, this.maxHp); // HPを回復し、最大HPを超えないようにする
        consumeMp(10); // 回復によってMPを消費
        return healAmount; // 回復量を返す
    }

    /**
     * 攻撃
     * @param random 乱数生成
     * @param targetHp 相手のHP
     * @return targetHp
     */
    public int attack(Random random, int targetHp) {
        int attackType = Main.random.nextInt(3); // 0～2の乱数を生成
        switch (attackType) {
            case 0:
                return attack1(targetHp);
            case 1:
                return attack2(targetHp);
            case 2:
                return attack3(targetHp);     
            default:
                return 0; // ここには到達しないはず
        }
    }

    /**
     * 攻撃1
     * @param targetHp 相手のHP
     * @return targetHp
     */
    protected abstract int attack1(int targetHp);
    
    /**
     * 攻撃2
     * @param targetHp 相手のHP
     * @return targetHp
     */
    protected abstract int attack2(int targetHp);

    /**
     * 攻撃3
     * @param targetHp 相手のHP
     * @return targetHp
     */
    protected abstract int attack3(int targetHp);

    /**
     * 特殊能力
     * 
     * @param targetHp
     */
    public abstract int specialAbility(int targetHp);

}
