package _20220902;

import java.util.Scanner;

public class BigNum {

	public static void main(String[] args) {
		int max;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 정수: ");
		int n1 = scanner.nextInt();
		
		System.out.print("두번째 정수: ");
		int n2 = scanner.nextInt();
		
		if (n1 > n2) {
			max = n1;
		}
		else {
			max = n2;
		}
		System.out.printf("큰 수는 %d", max);
	}

}
