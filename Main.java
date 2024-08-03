import java.util.Scanner;

public class Main extends Object {


    public static void main(String[] args) {
        // try-with-resourcesを使用してScannerを自動的に閉じる
        try (Scanner scanner = new Scanner(System.in)) {
            // 魔法使いを選択
            Wizard wizard = selectWizard(scanner);
            // 魔法使いの名前を設定
            setName(scanner, wizard);
            // 敵を生成
            Enemy[] enemies = new Enemy[] {
                    new DarkKnight("DarkKnight", 100, 10),
                    new DragonAvatar("DragonAvatar", 200, 20),
                    new PhantomMessenger("PhantomMessenger", 300, 30)
            };
            // 難易度設定
            setDifficulty(scanner, wizard);
            // 敵と魔法使いの戦闘
            for (Enemy enemy : enemies) {
                battle(wizard, enemy);
                if (wizard.hp <= 0) {
                    System.out.println("GAME OVER");
                    return;
                }
            }
            System.out.println("すべての敵を倒しました。");
            System.out.println("GAME CLEAR");
        } catch (Exception e) {
            System.out.println("エラーが発生しました。" + e.getMessage());
        }
    }

    /**
     * 魔法使いを選択する
     * 
     * @return 選択した魔法使い
     */
    public static Wizard selectWizard(Scanner scanner) {
        while (true) {
            // 水の魔法使いか火の魔法使いを選択
            System.out.println("呼び出す魔法使いの属性を選択してください。");
            System.out.println("1: 水の魔法使い");
            System.out.println("2: 火の魔法使い");

            int wizardType;
            try {
                wizardType = scanner.nextInt();
                scanner.nextLine(); // 改行をクリア
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
    public static void setName(Scanner scanner, Wizard wizard) {
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
    public static void setDifficulty(Scanner scanner, Wizard wizard) {
        while (true) {
            // 難易度設定
            System.out.println("難易度を選択してください。");
            System.out.println("1: かんたん");
            System.out.println("2: ふつう");
            System.out.println("3: むずかしい");

            int difficulty;
            try {
                difficulty = scanner.nextInt();
                scanner.nextLine(); // 改行をクリア
            } catch (Exception e) {
                System.out.println("1から3を入力してください。");
                scanner.next(); // 不正な入力をクリア
                continue;
            }

            switch (difficulty) {
                case 1:
                    wizard.setHp(100);
                    return;
                case 2:
                    wizard.setHp(50);
                    return;
                case 3:
                    wizard.setHp(30);
                    return;
                default:
                    System.out.println("1から3を入力してください。");
            }
        }
    }

    /**
     * 戦闘
     * 
     * @param wizard 魔法使い
     * @param enemy  敵
     */
    public static void battle(Wizard wizard, Enemy enemy) {
        // 敵と魔法使いの戦闘
        System.out.println("GAME START");
        System.out.println("敵：" + enemy.getName() + "が現れた！");

        while (enemy.getHp() > 0 && wizard.getHp() > 0) {

            // 魔法使いの攻撃
            System.out.println(wizard.getName() + " の攻撃！");
            enemy.takeDamage(wizard.attack(enemy.getHp()));
            System.out.println(enemy.getName() + " のHP：" + enemy.getHp());
            if (enemy.getHp() <= 0) {
                System.out.println(enemy.getName() + " を倒した！");
                break;
            }

            // 敵の攻撃
            System.out.println(enemy.getName() + " の攻撃！");
            enemy.attack(wizard);
            System.out.println(wizard.getName() + " のHP：" + wizard.getHp());
            if (wizard.getHp() <= 0) {
                break;
            }
        }
    }
}
