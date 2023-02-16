package _20220916;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int num = random.nextInt(100)+1;
		int cnt = 0;
		int input;
		int min = 1;
		int max = 100;
		
		while (true) {
			
			System.out.println("1 ~ 100 범위의 정수 입력하시오. ");
			cnt++;
			System.out.printf("%d>> ", cnt);
			input = scanner.nextInt();
			
			while (input > 100 || input < 1)
			{
				System.out.println("범위를 벗어났어요");
				System.out.println("1 ~ 100 범위의 정수 입력하시오. ");
				System.out.printf("%d>> ", cnt);
				input = scanner.nextInt();
			}
			
			if (num > input) {
				System.out.println("제시한 정수가 낮습니다.");
				if (cnt == 10) {
					System.out.println("시도횟수 초과");
					break;
				}
				min = input+1;
				System.out.printf("%d~%d\n", min, max);
			}
			else if (num < input) {
				System.out.println("제시한 정수가 높습니다.");
				if (cnt == 10) {
					System.out.println("시도횟수 초과");
					break;
				}
				max = input-1;
				System.out.printf("%d~%d\n", min, max);
			}
			else {
				System.out.printf("축하합니다. 시도횟수=%d", cnt);
				break;
			}
		}
	}

}
