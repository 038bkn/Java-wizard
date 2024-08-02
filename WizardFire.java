public class WizardFire extends Wizard {

    @Override
    public int attack(int slimeHp) {
        System.out.println("ファイヤーボール！！！");
        System.out.println("スライムに5ポイントのダメージを与えた！");
        slimeHp -= 5;
        return slimeHp;
    }

}
