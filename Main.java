import java.util.Scanner;

public class Main extends Object {

    public static void main(String[] args) {
        // try-with-resourcesを使用してScannerを自動的に閉じる
        try (Scanner scanner = new Scanner(System.in)) {
            // ストーリー開始
            GameUtils.startStory();

            // 魔法使いを選択
            Wizard wizard = GameUtils.selectWizard(scanner);

            // 魔法使いの名前を設定
            GameUtils.setName(scanner, wizard);

            // 魔法使いのバックストーリーを表示
            wizard.printBackstory();

            // 難易度設定
            GameUtils.setDifficulty(scanner, wizard);

            // 敵を生成
            Enemy[] enemies = new Enemy[] {
                    new DarkKnight("闇の騎士(DarkKnight)", 70, 5),
                    new DragonAvatar("竜の化身(DragonAvatar)", 100, 10),
                    new PhantomMessenger("幻影の使者(PhantomMessenger)", 130, 15)
            };

            // 敵と魔法使いの戦闘
            for (int i = 0; i < enemies.length; i++) {
                GameUtils.advanceStory(i + 1);
                GameUtils.characterDialogue(wizard, enemies[i]);
                GameUtils.battle(scanner, wizard, enemies[i]);

                if (wizard.getHp() <= 0) {
                    GameUtils.endStory(false);
                    return;
                } else if (wizard.getMp() <= 0) {
                    GameUtils.endStory(false);
                    return;
                }
            }

            GameUtils.endStory(true);
        } catch (Exception e) {
            System.out.println("エラーが発生しました。" + e.getMessage());
        }
    }
}