package _20220905;

import java.util.Scanner;

public class MaxNum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 정수: ");
		int n1 = scanner.nextInt();
		
		System.out.print("두번째 정수: ");
		int n2 = scanner.nextInt();
		
		System.out.print("세번째 정수: ");
		int n3 = scanner.nextInt();
		
		int max = n1;
		if (n1 < n2) {
			max = n2;
		}
		if (max < n3) {
			max = n3;
		}
		System.out.printf("가장 큰 수: %d", max);
	}

}
