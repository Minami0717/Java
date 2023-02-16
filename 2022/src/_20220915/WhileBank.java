package _20220915;

import java.util.Scanner;

public class WhileBank {

	public static void main(String[] args) {
		int money = 5000;
		int m;
		while (true) {
			System.out.println("--------------------------");
			System.out.println("1.예금| 2.출금| 3.잔고| 4.종료");
			System.out.println("--------------------------");
			System.out.print("선택> ");
			
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			
			switch (input) {
			case 1:
				System.out.print("예금액>");
				m = scanner.nextInt();
				money += m;
				break;
			case 2:
				System.out.print("출금액>");
				m = scanner.nextInt();
				money -= m;
				break;
			case 3:
				System.out.printf("잔고>%d\n", money);
				break;
			case 4:
				System.out.println("프로그램 종료");
				System.exit(0);
			default:
				System.out.println("메뉴 이외의 값이예용!");
				break;
			}
		}
	}

}
