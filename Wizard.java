public abstract class Wizard extends Object {

    String name;
    int hp;
    int mp;

    public void run() {
        System.out.println("逃げろー！！！");
    }

    public void heal() {
        System.out.println("回復させてあげる！");
    }

    public abstract int attack(int targetHp);

}
