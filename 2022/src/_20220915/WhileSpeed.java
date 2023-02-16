package _20220915;

import java.util.Scanner;

public class WhileSpeed {

	public static void main(String[] args) {
		int speed = 0;
		
		while (true) {
			System.out.println("-------------------");
			System.out.println("1.증속| 2.감속| 3.종료");
			System.out.println("-------------------");
			System.out.print("선택: ");
			
			Scanner scanner = new Scanner(System.in);
			int input = scanner.nextInt();
			
			switch (input) {
			case 1:
				speed++;
				System.out.printf("현재 속도=%d\n", speed);
				break;
			case 2:
				speed--;
				System.out.printf("현재 속도=%d\n", speed);
				break;
			case 3:
				System.out.println("프로그램 종료");
				System.exit(0);
			default:
				System.out.println("메뉴 이외의 값이예용!");
				break;
			}
		}
	}

}
