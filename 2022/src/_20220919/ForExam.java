package _20220919;

import java.util.Scanner;

public class ForExam {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수 입력: ");
		int num = scanner.nextInt();
		int cnt;
		int sum = 0;
		
		for (cnt = 1; cnt <= num; cnt++) {
			sum += cnt;
		}
		
		System.out.println("합계: " + sum);
	}
}
