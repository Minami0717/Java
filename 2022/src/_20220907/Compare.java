package _20220907;

import java.util.Scanner;

public class Compare {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("10~99 범위의 정수 입력하세요. ");
		
		while (!scanner.hasNextInt()) {
			scanner.next();
			System.out.println("10~99 범위의 정수가 아닙니다. 다시 입력하세요.");
		}
		
		int input = scanner.nextInt();
		
		while (input > 99 || input < 10) {
			System.out.println("10~99 범위의 정수가 아닙니다. 다시 입력하세요.");
			input = scanner.nextInt();
		}
		
		int f = input / 10;
		int s = input % 10;
		
		if (f == s)
			System.out.println("YES! 10의 자리와 1의 자리가 같습니다.");
		else
			System.out.println("NO! 10의 자리와 1의 자리가 같지 않습니다.");
	}

}
