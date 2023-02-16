package _20220905;

import java.util.Scanner;

public class RSP {

	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("사용자: ");
			String player = scanner.nextLine();
			System.out.print("컴퓨터: ");
			String computer = scanner.nextLine();
			
			if (player.equals("가위")) {
				if (computer.equals("가위"))
					System.out.println("무승부");
				else if (computer.equals("바위"))
					System.out.println("패배");
				else if (computer.equals("보"))
					System.out.println("승리");
			}
			if (player.equals("바위")) {
				if (computer.equals("가위"))
					System.out.println("승리");
				else if (computer.equals("바위"))
					System.out.println("무승부");
				else if (computer.equals("보"))
					System.out.println("패배");
			}
			if (player.equals("보")) {
				if (computer.equals("가위"))
					System.out.println("패배");
				else if (computer.equals("바위"))
					System.out.println("승리");
				else if (computer.equals("보"))
					System.out.println("무승부");
			}
			
			if ((player.equals("가위") && computer.equals("보")) || 
				(player.equals("바위") && computer.equals("가위")) ||
				(player.equals("보") && computer.equals("바위")))
				System.out.println("승리");
			else if (player.equals(computer))
				System.out.println("무승부");
			else
				System.out.println("패배");
		}
		
	}
}
