package _20221006;

import java.util.Random;
import java.util.Scanner;

public class AutoLotto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int[] comLotto = new int[7];
		int[] inputLotto = new int[6];
		int rank = 0;
		int choiceRank = 0;
		
		do {
			System.out.print("등수 선택(1 ~ 5): ");
			choiceRank = scanner.nextInt();
		} while (choiceRank > 5 || choiceRank < 1);
		
		while (rank != choiceRank) {
			int cnt = 0;
			int lotto = 0;
			int lottoCnt = 0;
			String money = "";
			boolean isBonus = false;
			boolean isWin = true;
			Boolean chk;
			
			while (lottoCnt < 7) {
				chk = true;
				lotto = random.nextInt(45)+1;
				
				for (int i = 0; i < lottoCnt; i++) {
					if (comLotto[i] == lotto) {
						chk = false;
						break;
					}
				}
				
				if (chk) {
					comLotto[lottoCnt] = lotto;
					lottoCnt++;
				}
			}
			
			System.out.print("컴퓨터 로또 번호: ");
			
			for (int i = 0; i < comLotto.length-1; i++) {
				System.out.printf("%5d", comLotto[i]);
			}
			
			System.out.printf("\t보너스 번호: %d\n", comLotto[6]);
			
			lottoCnt = 0;
			while (lottoCnt < 6) {
				chk = true;
				lotto = random.nextInt(45)+1;
				
				for (int i = 0; i < lottoCnt; i++) {
					if (inputLotto[i] == lotto) {
						chk = false;
						break;
					}
				}
				
				if (chk) {
					inputLotto[lottoCnt] = lotto;
					lottoCnt++;
				}
			}
			
			System.out.print("자동 로또 번호: 　");
			
			for (int i = 0; i < inputLotto.length; i++) {
				System.out.printf("%5d", inputLotto[i]);
			}
			
			System.out.println();
			
			for (int i = 0; i < inputLotto.length; i++) {
				for (int j = 0; j < inputLotto.length; j++) {
					if (comLotto[i] == inputLotto[j]) {
						cnt++;
					}
				}
			}
			
			for (int i = 0; i < inputLotto.length; i++) {
				if (inputLotto[i] == comLotto[6]) {
					isBonus = true;
				}
			}
			
			switch (cnt) {
			case 6:
				rank = 1;
				money = "30억";
				break;
			case 5:
				if (isBonus) {
					rank = 2;
					money = "6천만";
				}
				else {
					rank = 3;
					money = "150만";
				}
				break;
			case 4:
				rank = 4;
				money = "5만";
				break;
			case 3:
				rank = 5;
				money = "5천";
				break;
			default:
				isWin = false;
				break;
			}
			if (rank == 2)
				System.out.printf("당첨 번호 수: %d+1\t 순위: %d\t 당첨금: %s원\n", cnt, rank, money);
			else if (isWin)
				System.out.printf("당첨 번호 수: %d\t 순위: %d\t 당첨금: %s원\n", cnt, rank, money);
			else
				System.out.printf("당첨 번호 수: %d\t 꽝\n", cnt);
		}
		
	}
}
