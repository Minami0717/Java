package _20220902;

import java.util.Scanner;

public class IfEx {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int grade;
		
		System.out.print("정수 입력하세요.");
		grade = in.nextInt();
		
		if (grade >= 60) {
			System.out.print("합격");
		} else {
			System.out.print("불합");
		}
		
		System.out.println("입니다.\n");
	}

}
