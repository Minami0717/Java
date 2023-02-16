package _20220921;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean option = true;

		System.out.print("정수 입력하세요? ");
		int num = scanner.nextInt();
		
		for (int i = 2; i < num; i++) {
			if ((num % i) == 0) {
				option = false;
				break;
			}
		}
		
		if(option == true)
			System.out.println("소수입니다.");
		else
			System.out.println("소수아닙니다.");
	}

}
