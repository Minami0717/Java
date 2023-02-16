package _20220923;

import java.util.Scanner;

public class ForStr {
	
	public static void Turn(String str) {
		String l,r;
		
		System.out.println(str.length());
		
		for (int i = 0; i <= str.length(); i++) {
			System.out.println(str);
			l = str.substring(0,1);
			r = str.substring(1);
			str = r.concat(l);
		}
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("문자열을 입력하세요. ");
		String str = scanner.nextLine();
		
		Turn(str);
	}

}
