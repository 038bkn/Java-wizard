public abstract class Wizard extends Object {

    String name;
    int hp;
    int mp;

    public Wizard() {
        this.hp = 100;  // 基本的なHP
        this.mp = 50;   // 基本的なMP
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void takeDamage(int damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void heal() {
        System.out.println("回復させてあげる！");
    }

    public abstract int attack(int targetHp);

    public abstract void specialAbility(int targetHp);

}
