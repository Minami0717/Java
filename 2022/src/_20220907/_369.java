package _20220907;

import java.util.Scanner;

public class _369 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("1~999 범위의 정수 입력하세요. ");
			
			int num = scanner.nextInt();
			
			if (num == 0)
				break;
			
			while (num > 999 || num < 1) {
				System.out.println("1~999 범위의 정수가 아닙니다. 다시 입력하세요.");
				num = scanner.nextInt();
			}
			
			int f = num / 100;
			int s = (num / 10) % 10;
			int t = num % 10;
			int c = 0;
			
			System.out.println(f + " " + s + " " + t);
			
			if (f % 3 == 0 && f != 0)
				c++;
			if (s % 3 == 0 && s != 0)
				c++;
			if (t % 3 == 0 && t != 0)
				c++;
			
			if (c == 3)
				System.out.println("박수짝짝짝");
			else if (c == 2)
				System.out.println("박수짝짝");
			else if (c == 1)
				System.out.println("박수짝");
			else
				System.out.println("박수없당!!!");
		}
		
	}

}
