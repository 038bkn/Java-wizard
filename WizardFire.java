public class WizardFire extends Wizard {

    @Override
    public int attack(int targetHp) {
        System.out.println("ファイヤーボール！！！");
        System.out.println("スライムに5ポイントのダメージを与えた！");
        targetHp -= 5;
        return targetHp;
    }
}
