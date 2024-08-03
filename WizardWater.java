public class WizardWater extends Wizard {

    @Override
    public int attack(int targetHp) {
        System.out.println("水鉄砲ぶしゃー！！！");
        System.out.println("スライムに5ポイントのダメージを与えた！");
        targetHp -= 5;
        return targetHp;
    }

}
