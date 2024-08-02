import java.util.Scanner;

public class Main extends Object {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 水の魔法使いか火の魔法使いを選択
        System.out.println("呼び出す魔法使いの属性を選択してください。");
        System.out.println("1: 水の魔法使い");
        System.out.println("2: 火の魔法使い");
        int wizardType = scanner.nextInt();
        Wizard wizard = null; // スコープ外で宣言

        if (wizardType == 1) {
            // 水の魔法使いを選択
            wizard = new WizardWater();
        } else if (wizardType == 2) {
            // 火の魔法使いを選択
            wizard = new WizardFire();
        } else {
            System.out.println("1か2を入力してください。");
            return; // プログラム終了
        }

        // 魔法使いの名前を名前を設定
        System.out.println("魔法使いの名前を入力してください。");
        String name = scanner.next();
        wizard.name = name;

        // 魔法使いの名前を表示
        System.out.println("魔法使いの名前は" + wizard.name + "です。");

        // スライムを生成
        Slime slime = new Slime();
        
        System.out.println("GAME START");
        // 難易度設定
        System.out.println("難易度を選択してください。");
        System.out.println("1: かんたん");
        System.out.println("2: ふつう");
        System.out.println("3: むずかしい");
        int difficulty = scanner.nextInt();
        if (difficulty == 1) {
            wizard.hp = 10;
            slime.hp = 10;
        } else if (difficulty == 2) {
            wizard.hp = 30;
            slime.hp = 30;
        } else if (difficulty == 3) {
            wizard.hp = 50;
            slime.hp = 50;
        } else {
            System.out.println("1から3を入力してください。");
            return;
        } 
        // 魔法使いのHPを表示
        System.out.println(wizard.name + "のHPは" + wizard.hp + "です。");

        // スライムのHPを表示
        System.out.println("スライムのHPは" + slime.hp + "です。");

        System.out.println("GAME START");

        // スライムと魔法使いの戦闘
        while (slime.hp > 0 && wizard.hp > 0) {
            // 魔法使いの攻撃
            System.out.println(wizard.name + "の攻撃！");
            slime.hp = wizard.attack(slime.hp);
            System.out.println("スライムのHP：" + slime.hp);
            if (slime.hp <= 0) {
                break;
            }

            // スライムの攻撃
            wizard.hp = slime.attack(wizard.hp);
            System.out.println(wizard.name + "のHP：" + wizard.hp);
            if (wizard.hp <= 0) {
                break;
            }
        }

        if(wizard.hp > 0) {
            System.out.println("GAME CLEAR");
        } else {
            System.out.println("GAME OVER");
        }
    }
}
