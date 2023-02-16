package _20220915;

import java.util.Scanner;

public class DoWhileMonth {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int month;
		do {
			System.out.print("올바른 월을 입력하시오 [1-12]: ");
			month = scanner.nextInt();
		} while (month < 1 || month > 12);
		System.out.printf("입력한 월: %d", month);
	}

}
