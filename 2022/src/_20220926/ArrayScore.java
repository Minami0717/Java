package _20220926;

import java.util.Scanner;

public class ArrayScore {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생 수 입력하시오? ");
		int student = scanner.nextInt();
		
		int[] score = new int[student];
		
		for (int i = 0; i < score.length; i++) {
			System.out.printf("%d번째 학생의 성적 입력하시오? ", i+1);
			score[i] = scanner.nextInt();
		}
		
		System.out.printf("%d명의 학생성적은 다음과 같다\n", student);
		
		for (int i = 0; i < score.length; i++) {
			System.out.print(score[i] + " ");
		}
		System.out.println("\n");
		
		for (int i = 0; i < score.length; i++) {
			if (score[i] >= 90)
				System.out.printf("%d번 학생의 등급은 A입니다.\n", i+1);
			else if (score[i] >= 80)
				System.out.printf("%d번 학생의 등급은 B입니다.\n", i+1);
			else if (score[i] >= 70)
				System.out.printf("%d번 학생의 등급은 C입니다.\n", i+1);
			else if (score[i] >= 60)
				System.out.printf("%d번 학생의 등급은 D입니다.\n", i+1);
			else if (score[i] < 60)
				System.out.printf("%d번 학생의 등급은 F입니다.\n", i+1);
		}
	}

}
