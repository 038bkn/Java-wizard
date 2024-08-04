import java.util.Scanner;
import java.util.Random;

public class Main extends Object {

    public static Random random = new Random(); // Randomクラスのインスタンスを生成

    public static void main(String[] args) {
        // try-with-resourcesを使用してScannerを自動的に閉じる
        try (Scanner scanner = new Scanner(System.in)) {
            // ストーリー開始
            startStory();

            // 魔法使いを選択
            Wizard wizard = selectWizard(scanner);

            // 魔法使いの名前を設定
            setName(scanner, wizard);

            // 魔法使いのバックストーリーを表示
            wizard.printBackstory();

            // 難易度設定
            setDifficulty(scanner, wizard);

            // 敵を生成
            Enemy[] enemies = new Enemy[] {
                    new DarkKnight("DarkKnight(闇の騎士)", 100, 10),
                    new DragonAvatar("DragonAvatar(竜の化身)", 200, 20),
                    new PhantomMessenger("PhantomMessenger(幻影の使者)", 300, 30)
            };

            // 敵と魔法使いの戦闘
            for (int i = 0; i < enemies.length; i++) {
                advanceStory(i + 1);
                characterDialogue(wizard, enemies[i]);
                battle(scanner, wizard, enemies[i]);

                if (wizard.getMp() <= 0) {
                    endStory(false);
                    return;
                }
            }

            endStory(true);
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
                    return new WizardWater(null, 75);
                case 2:
                    return new WizardFire(null, 75);
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
            System.out.println(); // 改行
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
                    wizard.setHp(150);
                    wizard.maxHp = wizard.getHp();
                    wizard.setMp(1000);
                    wizard.maxMp = wizard.getMp();
                    wizard.normalAttackMpCost = 10;
                    wizard.specialAttackMpCost = 30;
                    return;
                case 2:
                    wizard.setHp(100);
                    wizard.maxHp = wizard.getHp();
                    wizard.setMp(75);
                    wizard.maxMp = wizard.getMp();
                    wizard.normalAttackMpCost = 15;
                    wizard.specialAttackMpCost = 40;
                    return;
                case 3:
                    wizard.setHp(70);
                    wizard.maxHp = wizard.getHp();
                    wizard.setMp(50);
                    wizard.maxMp = wizard.getMp();
                    wizard.normalAttackMpCost = 20;
                    wizard.specialAttackMpCost = 50;
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
        System.out.println(enemy.getName() + "が現れた！\n");
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
                    int healAmount = wizard.heal(random);
                    printStatus(wizard, enemy);
                    if (healAmount > 0) {
                        System.out.println(wizard.getName() + " は" + healAmount + "回復した！");
                    } else {
                        System.out.println("しかし、" + wizard.getName() + "のHPは満タンだ！");
                        System.out.println("もう一度選ばせてあげるっ！\n");
                    }
                    continue; // ターンを終了
                case 3:
                    System.out.println(); // 改行
                    System.out.println(wizard.getName() + " の必殺技！");
                    int specialDamage = wizard.specialAbility(random, enemy.getHp());
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

    public static void startStory() {
        System.out.println("遠い昔、世界は光と闇の均衡により保たれていた…");
        System.out.println("しかし、闇の勢力がその均衡を破り、世界を混沌に陥れた。");
        System.out.println("あなたは禁忌の力を持つ魔法使いとして、この闇を打ち破る使命を背負うことになった。");
        System.out.println("古の魔導書に記された力を駆使し、世界を救う旅に出るのだ。\n");
    }

    public static void advanceStory(int stage) {
        switch (stage) {
            case 1:
                System.out.println(); // 改行
                System.out.println("【ステージ1】暗黒の森");
                System.out.println("あなたは闇の勢力が潜む暗黒の森に足を踏み入れた。");
                System.out.println("突然、影のような生物が襲いかかってきた！");
                break;
            case 2:
                System.out.println(); // 改行
                System.out.println("【ステージ2】封印の洞窟");
                System.out.println("洞窟の奥深く、強力な魔物が封印されている。");
                System.out.println("あなたはその封印を解き、古の力を手に入れなければならない。");
                break;
            case 3:
                System.out.println(); // 改行
                System.out.println("【ステージ3】終焉の城");
                System.out.println("闇の勢力の本拠地、終焉の城に辿り着いた。");
                System.out.println("ここで最終決戦が待ち受けている。");
                break;
        }
    }

    public static void characterDialogue(Wizard wizard, Enemy enemy) {
        System.out.println(); // 改行
        System.out.println(enemy.getName() + ": 「お前如きが我を倒せると思うか？」");
        System.out.println(wizard.getName() + ": 「闇に染まったお前を、この手で葬る！」");
    }

    public static void endStory(boolean victory) {
        if (victory) {
            System.out.println(); // 改行
            System.out.println("【エンディング】");
            System.out.println("あなたは闇の勢力を打ち破り、世界に平和を取り戻した。");
            System.out.println("しかし、その戦いの代償として、多くの仲間を失った…");
            System.out.println("これからも続くであろう困難な道を、あなたは歩み続ける。");
        } else {
            System.out.println(); // 改行
            System.out.println("【ゲームオーバー】");
            System.out.println("あなたは闇の勢力に敗北し、世界は完全に闇に包まれた。");
            System.out.println("しかし、希望はまだ残っている。再び挑戦し、世界を救うのだ！");
        }
    }

}
