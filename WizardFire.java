public class WizardFire extends Wizard {

    @Override
    public int attack(int targetHp) {
        System.out.println("漆黒の闇の炎【ダークフレイム・マスターストライク】で攻撃した！");
        System.out.println("スライムに3ポイントのダメージを与えた！");
        targetHp -= 3;
        return targetHp;
    }
}
