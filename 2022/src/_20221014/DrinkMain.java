package _20221014;

import java.util.Scanner;

public class DrinkMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DrinkFunc drink = new DrinkFunc();
		
		while (true) {
			drink.menu();
			
			int input = scanner.nextInt();
			
			switch (input) {
			case 1:
				drink.input();
				break;
			case 2:
				drink.print();
				break;
			case 3:
				System.out.println("종료합니다.");
				return;
			default:
				break;
			}
		}
	}

}
