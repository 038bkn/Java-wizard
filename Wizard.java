public abstract class Wizard extends Object {

    protected String name;
    protected int hp;
    protected int mp;

    /**
     * コンストラクタ
     */
    public Wizard() {
        this.hp = 100;  // 基本的なHP
        this.mp = 50;   // 基本的なMP
    }

    /**
     * 名前を取得
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 名前を設定
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * HPを取得
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * HPを設定
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * MPを取得
     * @return mp
     */
    public int getMp() {
        return mp;
    }

    /**
     * MPを設定
     * @param mp
     */
    public void setMp(int mp) {
        this.mp = mp;
    }

    /**
     * ダメージを受ける
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
    public void heal() {
        System.out.println("回復してあげる！");
        this.hp += 10;
    }

    /**
     * 攻撃
     * @param targetHp 
     * @return targetHp
     */
    public abstract int attack(int targetHp);

    /**
     * 特殊能力
     * @param targetHp
     */
    public abstract int specialAbility(int targetHp);

}
