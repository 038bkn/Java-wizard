import java.util.Scanner;

public class Main extends Object {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            // 魔法使いを選択
            Wizard wizard = GameUtils.selectWizard();
            // 魔法使いの名前を設定
            GameUtils.setName(wizard);
            // スライムを生成
            Slime slime = new Slime();
            // 難易度設定
            GameUtils.setDifficulty(wizard, slime);
            // スライムと魔法使いの戦闘
            GameUtils.battle(wizard, slime);
        } finally {
            scanner.close(); // Scannerを閉じる
        }
    }
}