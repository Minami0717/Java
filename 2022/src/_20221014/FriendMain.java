package _20221014;

import java.util.Scanner;

public class FriendMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		FriendFunc friend = new FriendFunc();
		
		while (true) {
			friend.menu();
			
			int input = scanner.nextInt();
			
			switch (input) {
			case 1:
				friend.input();
				break;
			case 2:
				friend.search();
				break;
			case 3:
				friend.delete();
				break;
			case 4:
				friend.print();
				break;
			case 5:
				System.out.println("종료합니다.");
				return;
			default:
				break;
			}
		}
	}

}
