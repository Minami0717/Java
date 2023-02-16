package _20220916;

import java.util.Random;
import java.util.Scanner;

public class CoinGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String str = "";
		String c = "";
		int money = 10000;
		
		while (true) {
			System.out.printf("소지금: %d\n", money);
			System.out.print("영희 동전 던집니다. Enter 입력하세요?");
			scanner.nextLine();
			money -= 1000;
			System.out.printf("소지금: %d\n", money);
			int coin = random.nextInt(2)+1;
			
			switch (coin) {
			case 1:
				c = "앞면";
				break;
			case 2:
				c = "뒷면";
			}
			
			System.out.print("앞면 뒷면 선택하세요.");
			String input = scanner.nextLine();
			
			System.out.printf("영희의 동전은 %s\n", c);
			
			if (c.equals(input)) {
				System.out.println("정답입니다.\n");
				money += 2000;
				System.out.printf("소지금: %d\n", money);
			}
			else
				System.out.println("오답입니다.\n");
			
			System.out.print("계속할까요(Y/N)? ");
			str = scanner.nextLine();
			char yn = str.charAt(0);
			
			if (yn == 'y' || yn == 'Y')
				continue;
			else if (yn == 'n' || yn == 'N')
				break;
		}
		
		System.out.println("게임을 종료합니다");
	}

}
