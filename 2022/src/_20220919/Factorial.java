package _20220919;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int fact = 1;
		int n;
		
		System.out.print("정수를 입력하시오: ");
		n = scanner.nextInt();
		System.out.printf("%d! = ", n);
		
		for (int i = n; i >= 1; i--) {
			fact *= i;
			
			if (i == 1)
				System.out.println(i);
			else
				System.out.print(i + " * ");
		}
		
		System.out.printf("%d! = %d", n, fact);
	}

}
