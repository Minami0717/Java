package _20220915;

import java.util.Random;
import java.util.Scanner;

public class DiceGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		String yn = "";
		System.out.println("안녕하세요^^");
		System.out.println("N I C E  G A M E\n");
		
		while (true) {
			System.out.println("주사위를 굴려 볼까오.");
			
			System.out.print("사람 주사위 굴립니다(ENTER 하세요)");
			scanner.nextLine();
			int player = random.nextInt(6)+1;
			System.out.printf("사람의 숫자는 : %d 입니다\n\n", player);
			
			System.out.print("컴퓨터 주사위 굴립니다(ENTER 하세요)");
			scanner.nextLine();
			int com = random.nextInt(6)+1;
			System.out.printf("컴퓨터의 숫자는 : %d 입니다\n\n", com);
			
			if (player > com)
				System.out.println("사용자 승\n");
			else if (player < com)
				System.out.println("컴퓨터 승\n");
			else
				System.out.println("무승부\n");
			
			System.out.print("계속할까요(Y/N)? ");
			yn = scanner.nextLine();
			
			if (yn.equals("y") || yn.equals("Y"))
				continue;
			else if (yn.equals("n") || yn.equals("N"))
				break;
		}
		
		System.out.println("게임을 종료합니다");
	}

}
