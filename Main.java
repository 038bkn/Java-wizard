import java.util.Scanner;

public class Main extends Object {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // 魔法使いを選択
            Wizard wizard = selectWizard();
            // 魔法使いの名前を設定
            setName(wizard);
            // 敵を生成
            Enemy darkKnight = new DarkKnight();
            Enemy dragonAvatar = new DragonAvatar();
            Enemy phantomMessenger = new PhantomMessenger();
            // 難易度設定
            setDifficulty(wizard);
            // 敵と魔法使いの戦闘
            battle(wizard, darkKnight);
            battle(wizard, dragonAvatar);
            battle(wizard, phantomMessenger);
        } finally {
            scanner.close(); // Scannerを閉じる
        }
    }

    /**
     * 魔法使いを選択する
     * 
     * @return 選択した魔法使い
     */
    public static Wizard selectWizard() {
        while (true) {
            // 水の魔法使いか火の魔法使いを選択
            System.out.println("呼び出す魔法使いの属性を選択してください。");
            System.out.println("1: 水の魔法使い");
            System.out.println("2: 火の魔法使い");

            int wizardType;
            try {
                wizardType = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("1か2を入力してください。");
                scanner.next(); // 不正な入力をクリア
                continue;
            }

            // 選択した魔法使いを生成
            switch (wizardType) {
                case 1:
                    return new WizardWater();
                case 2:
                    return new WizardFire();
                default:
                    System.out.println("1か2を入力してください。");
            }
        }
    }

    /**
     * 魔法使いの名前を設定
     * 
     * @param wizard 魔法使い
     */
    public static void setName(Wizard wizard) {
        // 魔法使いの名前を名前を設定
        System.out.println("魔法使いの名前を入力してください。");
        String name = scanner.next();
        wizard.name = name;
        // 魔法使いの名前を表示
        System.out.println("魔法使いの名前は" + wizard.name + "です。");
    }

    /**
     * 難易度設定
     * 
     * @param wizard 魔法使い
     */
    public static void setDifficulty(Wizard wizard) {
        while (true) {
            // 難易度設定
            System.out.println("難易度を選択してください。");
            System.out.println("1: かんたん");
            System.out.println("2: ふつう");
            System.out.println("3: むずかしい");

            int difficulty;
            try {
                difficulty = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("1から3を入力してください。");
                scanner.next(); // 不正な入力をクリア
                continue;
            }

            switch (difficulty) {
                case 1:
                    wizard.hp = 900;
                    return;
                case 2:
                    wizard.hp = 30;
                    return;
                case 3:
                    wizard.hp = 50;
                    return;
                default:
                    System.out.println("1から3を入力してください。");
            }
        }
    }

    /**
     * 敵と魔法使いの戦闘
     * 
     * @param wizard 魔法使い
     * @param enemy  敵
     */
    public static void battle(Wizard wizard, Enemy enemy) {
        // 敵と魔法使いの戦闘
        System.out.println("GAME START");

        while (enemy.hp > 0 && wizard.hp > 0) {

            // 魔法使いの攻撃
            System.out.println(wizard.name + "の攻撃！");
            enemy.hp = wizard.attack(enemy.hp);
            System.out.println("敵のHP：" + enemy.hp);
            if (enemy.hp <= 0) {
                break;
            }

            // 敵の攻撃
            wizard.hp = enemy.attack(wizard.name, enemy.attackPower, wizard.hp);
            System.out.println("敵の反撃！");
            System.out.println(wizard.name + "のHP：" + wizard.hp);
            if (wizard.hp <= 0) {
                break;
            }
        }

        if (wizard.hp > 0) {
            System.out.println("GAME CLEAR");
        } else {
            System.out.println("GAME OVER");
        }
    }
}
