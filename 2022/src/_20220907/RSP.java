package _20220907;

import java.util.Random;
import java.util.Scanner;

public class RSP {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("가위, 바위, 보 입력하세요. ");
			String player = scanner.nextLine();
			String computer = "";
			Random random = new Random();
			int com = random.nextInt(3);
			
			switch (com) {
			case 0:
				computer = "가위";
				System.out.printf("컴퓨터: %s\n", computer);
				break;
			case 1:
				computer = "바위";
				System.out.printf("컴퓨터: %s\n", computer);
				break;
			case 2:
				computer = "보";
				System.out.printf("컴퓨터: %s\n", computer);
				break;
			default:
				break;
			}
			
			if ((player.equals("가위") && computer.equals("보")) || 
				(player.equals("바위") && computer.equals("가위")) ||
				(player.equals("보") && computer.equals("바위")))
					System.out.println("사용자 승리");
				else if (player.equals(computer))
					System.out.println("무승부");
				else
					System.out.println("컴퓨터 승리");
			
			System.out.println("계속할까요? 예(Y)/아니오(N)");
			String con = scanner.nextLine();
			if (con.equals("n") || (con.equals("N")))
				break;
		}
		System.out.println("게임 종료");
	}

}
