package _20220923;

import java.util.Scanner;

public class ForAlpahbet1 {

	public static void alpahbet(char alpa) {
		for (char i = 'A'; i <= alpa; i++) {
			for (char j = 'A'; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("알파벳 입력하세요. ");
		String alpa = scanner.next();
		
		alpahbet(alpa.toUpperCase().charAt(0));
	}

}
