package _20220923;

import java.util.Scanner;

public class Array1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] scores = new int[3];
		int sum = 0;
		
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scanner.nextInt();
			sum += scores[i];
		}
		System.out.println("총합: " + sum);
	}

}
