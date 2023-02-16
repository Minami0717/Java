package _20221013;

import java.util.Scanner;

public class PhoneBook02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		PhoneInfo pInfo = new PhoneInfo();
		
		while (true) {
			pInfo.menu();
			
			int input = scanner.nextInt();
			
			switch (input) {
			case 1:
				pInfo.input();
				break;
			case 2:
				System.out.println("종료합니다.");
				return;
			default:
				break;
			}
		}
	}

}
