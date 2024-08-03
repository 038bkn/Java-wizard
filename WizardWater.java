public class WizardWater extends Wizard {

    @Override
    public int attack(int targetHp) {
        System.out.println("氷結の波動【フロストウェーブ】！！！");
        System.out.println("スライムに3ポイントのダメージを与えた！");
        targetHp -= 5;
        return targetHp;
    }

}
