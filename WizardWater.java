public class WizardWater extends Wizard {

    @Override
    public int attack(int slimeHp) {
        System.out.println("水鉄砲ぶしゃー！！！");
        System.out.println("スライムに5ポイントのダメージを与えた！");
        slimeHp -= 5;
        return slimeHp;
    }

}
