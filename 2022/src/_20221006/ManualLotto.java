package _20221006;

import java.util.Random;
import java.util.Scanner;

public class ManualLotto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int[] comLotto = new int[6];
		int[] inputLotto = new int[6];
		
		while (true) {
			int bonusLotto = random.nextInt(45)+1;
			int cnt = 0;
			int rank = 0;
			String money = "";
			boolean isBonus = false;
			boolean isWin = true;
			
			for (int i = 0; i < inputLotto.length; i++) {
				System.out.printf("로또 번호 %d번째 입력>> ", i+1);
				inputLotto[i] = scanner.nextInt();
			}
			
			System.out.printf("컴퓨터 로또 번호: ");
			for (int i = 0; i < comLotto.length; i++) {
				comLotto[i] = random.nextInt(45)+1;
				for (int j = 0; j < comLotto.length; j++) {
					
					while ((comLotto[i] == comLotto[j] && i != j) || comLotto[i] == bonusLotto) {
						comLotto[i] = random.nextInt(45)+1;
					}
				}
				System.out.printf("%5d", comLotto[i]);
			}
			System.out.printf("\t보너스 번호: %d\n", bonusLotto);
			
			System.out.print("입력된 로또 번호: ");
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
				if (inputLotto[i] == bonusLotto) {
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
			
			System.out.printf("재도전?(y/n) ");
			String yn = scanner.next();
			
			if (yn.equalsIgnoreCase("n")) {
				break;
			}
			else
				continue;
		}
		
	}
}
