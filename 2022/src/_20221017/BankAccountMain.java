package _20221017;

import java.util.Scanner;

public class BankAccountMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankAccountManager bManager = new BankAccountManager();
		
		while (true) {
			bManager.menu();
			int n = scanner.nextInt();
			
			switch (n) {
			case 1:
				bManager.create();
				break;
			case 2:
				bManager.print();
				break;
			case 3:
				bManager.plusMoney();
				break;
			case 4:
				bManager.minusMoney();
				break;
			case 5:
				bManager.sendMoney();
				break;
			case 6:
				System.out.println("종료합니다.");
				return;
			default:
				break;
			}
		}
	}

}
