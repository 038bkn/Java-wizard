import java.util.Scanner;
import java.util.Random;

public class Main extends Object {

    public static Random random = new Random(); // Randomクラスのインスタンスを生成

    public static void main(String[] args) {
        // try-with-resourcesを使用してScannerを自動的に閉じる
        try (Scanner scanner = new Scanner(System.in)) {
            // 魔法使いを選択
            Wizard wizard = selectWizard(scanner);
            // 魔法使いの名前を設定
            setName(scanner, wizard);
            // 敵を生成
            Enemy[] enemies = new Enemy[] {
                    new DarkKnight("DarkKnight(闇の騎士)", 100, 10),
                    new DragonAvatar("DragonAvatar(竜の化身)", 200, 20),
                    new PhantomMessenger("PhantomMessenger(幻影の使者)", 300, 30)
            };
            // 難易度設定
            setDifficulty(scanner, wizard);
            // 敵と魔法使いの戦闘
            for (Enemy enemy : enemies) {
                battle(scanner, wizard, enemy);
                if (wizard.getMp() <= 0) {
                    System.out.println("MPが尽きてしまいました。");
                    System.out.println("GAME OVER");
                    return;
                } else if (wizard.getHp() <= 0) {
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
        System.out.println(); // 改行
        // 魔法使いの名前を名前を設定
        System.out.println("魔法使いの名前を入力してください。");
        String name = scanner.next();
        wizard.setName(name);
        // 魔法使いの名前を表示
        System.out.println("魔法使いの名前は" + wizard.getName() + "です。\n");
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
                    wizard.maxHp = wizard.getHp();
                    return;
                case 2:
                    wizard.setHp(50);
                    wizard.maxHp = wizard.getHp();
                    return;
                case 3:
                    wizard.setHp(30);
                    wizard.maxHp = wizard.getHp();
                    return;
                default:
                    System.out.println("1から3を入力してください。");
            }
        }
    }

    public static void printStatus(Wizard wizard, Enemy enemy) {
        System.out.println(wizard.getName() + " のHP：" + wizard.getHp());
        System.out.println(wizard.getName() + " のMP：" + wizard.getMp());
        System.out.println(enemy.getName() + " のHP：" + enemy.getHp() + "\n");
    }

    /**
     * 戦闘
     * 
     * @param wizard 魔法使い
     * @param enemy  敵
     */
    public static void battle(Scanner scanner, Wizard wizard, Enemy enemy) {

        // 敵と魔法使いの戦闘
        System.out.println();
        System.out.println("┏━━━━━━━━━━━━┓");
        System.out.println("┃ GAME START ┃");
        System.out.println("┗━━━━━━━━━━━━┛\n");
        System.out.println("敵：" + enemy.getName() + "が現れた！\n");
        printStatus(wizard, enemy);

        while (enemy.getHp() > 0 && wizard.getHp() > 0) {

            // プレイヤーのターン
            System.out.println(wizard.getName() + " のターン！");
            System.out.println("1: 通常攻撃");
            System.out.println("2: 回復");
            System.out.println("3: 必殺技");

            int action;
            try {
                action = scanner.nextInt();
                scanner.nextLine(); // 改行をクリア
            } catch (Exception e) {
                System.out.println("1から3を入力してください。");
                scanner.next(); // 不正な入力をクリア
                continue;
            }

            switch (action) {
                case 1:
                    System.out.println(); // 改行
                    System.out.println(wizard.getName() + " の攻撃！");
                    int damage = wizard.attack(random, enemy.getHp());
                    enemy.takeDamage(damage);
                    System.out.println("敵に" + damage + "のダメージを与えた！");
                    break;
                case 2:
                    System.out.println(); // 改行
                    System.out.println(wizard.getName() + " は回復した！");
                    int healAmount = wizard.heal();
                    printStatus(wizard, enemy);
                    if (healAmount > 0) {
                        System.out.println(wizard.getName() + " は" + healAmount + "回復した！");
                    } else {
                        System.out.println("しかし、" + wizard.getName() + "のHPは満タンだ！");
                        System.out.println("もう一度選ばせてあげるっ！\n");
                    }
                    continue; // ターンを終了
                case 3:
                    System.out.println(wizard.getName() + " の必殺技！");
                    int specialDamage = wizard.specialAbility(enemy.getHp());
                    enemy.takeDamage(specialDamage);
                    System.out.println(wizard.getName() + " は" + enemy.getName() + "に" + specialDamage + "のダメージを与えた！");
                    break;
                default:
                    System.out.println("1から3を入力してください。");
                    continue;
            }

            // 魔法使いの攻撃
            System.out.println(); // 改行
            printStatus(wizard, enemy);
            if (enemy.getHp() <= 0) {
                System.out.println(enemy.getName() + " を倒した！");
                break;
            }

            // 敵のターン
            System.out.println(enemy.getName() + " のターン！");
            int damage = enemy.attack(random, wizard.getHp());
            wizard.takeDamage(damage);
            System.out.println(enemy.getName() + " は" + wizard.getName() + " に" + damage + "のダメージを与えた！");
            System.out.println(); // 改行
            printStatus(wizard, enemy);
            if (wizard.getHp() <= 0) {
                break;
            }
        }
    }
}
