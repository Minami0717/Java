package _20220914;

import java.util.Scanner;

public class WhileInput {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		int cnt = 1;
		
		while (cnt <= num) {
			System.out.print(cnt + " ");
			cnt++;
		}
	}

}
