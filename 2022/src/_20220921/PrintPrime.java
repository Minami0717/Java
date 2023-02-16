package _20220921;

import java.util.Scanner;

public class PrintPrime {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean option = true;

		System.out.print("정수 입력하세요? ");
		int num = scanner.nextInt();
		
		for (int i = 2; i < num; i++) {
			option = true;
			
			for (int j = 2; j < i; j++) {
				if ((i % j) == 0) {
					option = false;
					break;
				}
			}
			if (option == true)
				System.out.print(i+" ");
		}
	}

}
