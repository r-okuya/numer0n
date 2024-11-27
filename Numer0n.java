package Numer0n.numeron_okuya;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Numer0n {

	public static void main(String args[]) {

		// 変数設定

		// 生成した解答用配列
		int answer[] = new int[4];
		// 入力した数値を格納する配列
		int input[] = new int[4];

		// 4桁乱数生成
		for (int i = 0; i <= 3; i++) {

			// 重複カウント用
			int count = 0;
			// 乱数一時格納用
			int ans = (int) (Math.random() * 10);

			for (int chk = 0; chk <= 3; chk++) {
				if (answer[chk] == ans) {
					count++;
				}
			}

			// 重複チェック部
			if (count > 0) {
				i--;
				count = 0;
				continue;
			} else {
				answer[i] = ans;
			}

		}

		System.out.println("4桁の数字を入力してください");

		// 挑戦回数分ループ部
		for (int time = 1; time <= 10; time++) {

			// キーボードから入力した4桁格納用
			int org = 0;
			System.out.print((time) + "回目：");

			// キーボードから入力受付
			try {
				Scanner scanner = new Scanner(System.in);
				org = scanner.nextInt();

				// 4桁以外の場合は例外処理
				if (String.valueOf(org).length() != 4) {
					throw new InputMismatchException();
				}
			} catch (InputMismatchException e) {
				System.out.print("4桁の数字を入力してください。\n");
				time--;
				continue;
			}

			// キーボードからの入力を配列に代入
			int orin = 0;
			for (int orgc = 3; orgc >= 0; orgc--) {

				orin = org % 10;
				input[orgc] = orin;
				org = org / 10;
			}

			// Eatカウント用
			int ec = 0;

			// Biteカウント用
			int bc = 0;

			// Eat判定部
			for (int j = 0; j <= 3; j++) {
				if (answer[j] == input[j]) {

					// Eatカウントをインクリメント
					ec++;

				} else {

					// Bite判定部
					for (int k = 0; k <= 3; k++) {
						if (j != k) {
							if (answer[j] == input[k]) {

								// Biteカウントをインクリメント
								bc++;
							}
						}
					}
				}
			}

			// Eat,Bite表示
			System.out.println(ec + "EAT " + bc + "BITE");

			// Eatが4の場合勝利
			if (ec == 4) {
				System.out.println("\nあなたの勝ちです");
				break;

				// 挑戦回数が10回に到達で終了
			} else if (time == 10) {
				System.out.println("\n10回以内に正解しませんでした。あなたの負けです");
			} else {
				System.out.println("4桁の数字を入力してください。");
			}
		}
	}
}