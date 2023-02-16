package _20220908;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요");
		int number = scanner.nextInt();
		
		switch (number) {
		case 0:
			System.out.println("없음");
			break;
		case 1:
			System.out.println("하나");
			break;
		case 2:
			System.out.println("둘");
			break;
		default:
			System.out.println("많음");
			break;
		}
	}

}
