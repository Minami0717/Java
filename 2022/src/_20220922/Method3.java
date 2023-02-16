package _20220922;

import java.util.Scanner;

public class Method3 {
	
	public static int mul(int x, int y) {
		return x * y;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("정수1: ");
		int num1 = scanner.nextInt();
		System.out.print("정수2: ");
		int num2 = scanner.nextInt();
		
		System.out.println("곱: " + mul(num1, num2));
	}

}
