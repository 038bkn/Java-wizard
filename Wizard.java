public abstract class Wizard extends Object {

    String name;

    public void heal() {
        System.out.println("回復させてあげる！");
    }

    public void run() {
        System.out.println("逃げろー！！！");
    }

    public abstract void attack();

}
