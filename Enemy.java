import java.util.Random;

public abstract class Enemy extends Object {

    private String name;
    private int hp;

    /**
     * コンストラクタ
     * 
     * @param name
     * @param hp
     * @param attackPower
     */
    public Enemy(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
    }

    /**
     * 名前を取得
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * HPを取得
     * 
     * @return
     */
    public int getHp() {
        return hp;
    }

    /**
     * 攻撃力を取得
     * 
     * @return
     */
    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
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
        int attackType = random.nextInt(3); // 0～2の乱数を生成
        switch (attackType) {
            case 0:
                return attack1(targetHp);
            case 1:
                return attack2(targetHp);
            case 2:
                return attack3(targetHp);
            default:
                return 0;
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
     * @param targetHp 相手のHP
     * @return targetHp
     */
    public abstract int specialAbility(Wizard targetHp);

}