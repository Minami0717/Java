package _20221006;

import java.util.Scanner;

public class ArrayMethodTest {
	static Scanner scanner = new Scanner(System.in);
	
	public static void getValues(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print("성적을 입력하시오: ");
			array[i] = scanner.nextInt();
		}
	}
	
	public static void getAverage(int[] array) {
		int sum = 0;
		
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		
		double avg = sum/array.length;
		System.out.printf("평균 성적은 %.1f입니다", avg);
	}
	
	public static void main(String[] args) {
		int[] scores = new int[5];
		
		getValues(scores);
		getAverage(scores);
	}

}
