package _20220915;

import java.util.Scanner;

public class DoWhileGrade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int kor, eng, math;
		String grade;
		
		do {
			System.out.print("국어 = ");
			kor = scanner.nextInt();
		} while (kor < 0 || kor > 100);
		do {
			System.out.print("영어 = ");
			eng = scanner.nextInt();
		} while (eng < 0 || eng > 100);
		do {
			System.out.print("수학 = ");
			math = scanner.nextInt();
		} while (math < 0 || math > 100);
		
		int sum = kor + eng + math;
		double avg = sum / 3;
		System.out.printf("\n총점 = %d\n", sum);
		System.out.printf("평균 = %.2f\n", avg);
		
		switch ((int)avg/10) {
		case 10: case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		
		System.out.printf("학점 = %s학점", grade);
	}

}
