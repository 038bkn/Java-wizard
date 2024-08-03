public abstract class Enemy extends Object {

    protected String name;
    protected int hp;
    protected int attackPower;

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
        this.attackPower = attackPower;
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
     * 生存判定
     * 
     * @return
     */
    public boolean isAlive() {
        return this.hp > 0;
    }

    public abstract void attack(Wizard target);

    public abstract void specialAbility(Wizard target);

}