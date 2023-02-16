package _20220908;

import java.util.Scanner;

public class SwitchCalc {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자1 입력하세요: ");
		int num1 = scanner.nextInt();
		
		System.out.print("연산기호를 입력하세요: ");
		String mark = scanner.next();
		
		System.out.print("숫자2 입력하세요: ");
		int num2 = scanner.nextInt();
		
		int res = 0;
		boolean error = false;
		
		switch (mark) {
		case "+":
			res = num1 + num2;
			break;
		case "-":
			res = num1 - num2;
			break;
		case "*":
			res = num1 * num2;
			break;
		case "/":
			res = num1 / num2;
			break;
		default:
			error = true;
			break;
		}
		
		if (error == true)
			System.out.println("잘못된 연산자입니다.");
		else
			System.out.printf("%d %s %d = %d", num1, mark, num2, res);
	}

}
