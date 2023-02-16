package _20220929;

import java.util.Random;
import java.util.Scanner;

public class ArrayRanNum {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("인원 수 입력하세요? ");
			int n = scanner.nextInt();
			
			int[] win = new int[n];
			int[] ranNum = new int[n];
			int max = 0;
			int cnt = 0;
			
			for (int i = 0; i < n; i++) {
				ranNum[i] = random.nextInt(n);
				System.out.print(ranNum[i] + " ");
				win[ranNum[i]]++;
			}
			System.out.println("\n");
			
			for (int i = 0; i < n; i++) {
				System.out.printf("[%2d] : %d\n", i+1, win[i]);
				if (max < win[i]) {
					max = win[i];
				}
			}
			
			for (int i = 0; i < n; i++) {
				if (max == win[i]) {
					cnt++;
					System.out.printf("당첨 : win[%d] ", i+1);
				}
			}
			System.out.printf("\n%d명 당첨\n", cnt);
			
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
