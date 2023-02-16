package _20220923;

import java.util.Scanner;

public class ForAlpahbet {
	
	public static void alpahbet(char alpa) {
		for (char i = alpa; i >= 'a'; i--) {
			for (char j = 'a'; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("알파벳 입력하세요. ");
		String alpa = scanner.next();
		
		alpahbet(alpa.charAt(0));
	}

}
