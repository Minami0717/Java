package _20220902;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		while (true) {
			int i;
			String res = "";
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("정수: ");
			int input = i = scanner.nextInt();
			
			if (input <= 0 || input > 99) {
				break;
			}
			
			res = (i % 2) + res; i /= 2;
			res = (i % 2) + res; i /= 2;
			res = (i % 2) + res; i /= 2;
			res = (i % 2) + res; i /= 2;
			res = (i % 2) + res; i /= 2;
			res = (i % 2) + res; i /= 2;
			
			res = i + res;
			System.out.printf("%d: %s\n", input, res);
			System.out.printf("%d: %s\n", input, Integer.toBinaryString(input));
		}
		
	}

}
