package _20220929;

import java.util.Random;
import java.util.Scanner;

public class ArrayRandom {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("인원 수 입력하세요? ");
			int n = scanner.nextInt();
			
			char[] ox = new char[n];
			int randNum = random.nextInt(n);
			
			for (int i = 0; i < ox.length; i++) {
				if (i == randNum)
					ox[i] = 'X';
				else
					ox[i] = 'O';
				System.out.printf("%d번째: %c\n", i, ox[i]);
			}
			
			System.out.printf("당첨 %d번 밥 못 먹어요.\n", randNum);
			System.out.print("게임 계속할까요(Y/N)? ");
			String yn = scanner.next();
			
			if (yn.equalsIgnoreCase("n")) {
				System.out.println("게임 종료");
				break;
			}
			else if (yn.equalsIgnoreCase("y"))
				continue;
		}
		
	}

}
