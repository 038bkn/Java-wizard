public class Slime extends Object {
    
    int hp;

    public int attack(int wizardHp) {
        System.out.println("スライムの攻撃！");
        System.out.println("魔法使いに5ポイントのダメージを与えた！");
        wizardHp -= 5;
        return wizardHp;
    }

}
