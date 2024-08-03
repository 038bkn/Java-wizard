public class PhantomMessenger extends Enemy {
    
    @Override
    public int attack(String wizard, int attackPower, int targetHp) {
        System.out.println("敵の攻撃！");
        System.out.println(wizard + "に" + attackPower + "ポイントのダメージを与えた！");
        targetHp -= 15;
        return targetHp;
    }

    @Override
    public int specialAbility(String wizardName, int attackPower, int targetHp) {
        System.out.println("敵の特殊能力発動！");
        System.out.println(wizardName + "に" + attackPower + "ポイントのダメージを与えた！");
        targetHp -= 30;
        return targetHp;
    }

}
