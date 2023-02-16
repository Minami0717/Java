package _20220914;

import java.util.Scanner;

public class WhileGugu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("구구단 중에서 출력하고 싶은 단을 입력하세요: ");
			int dan = scanner.nextInt();
			if (dan == 0)
				break;
			
			int i = 1;
			
			while (i <= 9) {
				System.out.printf("%d * %d = %d\n", dan, i, dan*i);
				i++;
			}
		}
		
	}

}
