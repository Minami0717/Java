package _20221017;

import java.util.Scanner;

public class BankAccountManager {
	Scanner scanner = new Scanner(System.in);
	BankAccountData[] accountDatas = new BankAccountData[10];
	int count = 0;
	
	void menu() {
		System.out.println("---------------------------------------");
		System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.송금|6.종료");
		System.out.println("---------------------------------------");
		System.out.print("선택> ");
	}
	
	void create() {
		System.out.println("-------------");
		System.out.println("계좌생성");
		System.out.println("-------------");
		
		System.out.print("계좌번호: ");
		String accountNum = scanner.next();
		
		System.out.print("계좌주: ");
		String name = scanner.next();
		
		System.out.print("초기입금액: ");
		int money = scanner.nextInt();
		
		System.out.print("비밀번호: ");
		String password = scanner.next();
		
		accountDatas[count++] = new BankAccountData(name, accountNum, money, password);
		System.out.println("계좌가 생성되었습니다.");
	}
	
	void print() {
		if (count == 0) {
			System.out.println("계좌가 없습니다.");
			return;
		}
		
		for (int i = 0; i < count; i++) {
			accountDatas[i].list();
		}
	}
	
	void plusMoney() {
		boolean isAccount = false;
		
		System.out.print("계좌번호: ");
		String accountNum = scanner.next();
		
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(accountDatas[i].getAccountNum())) {
				isAccount = true;
				
				System.out.print("입금액: ");
				int money = scanner.nextInt();
				
				accountDatas[i].setMoney(accountDatas[i].getMoney()+money);
				System.out.println("입금완료");
			}
		}
		
		if (isAccount == false) {
			System.out.println("계좌번호가 존재하지 않습니다.");
		}
		
	}
	
	void minusMoney() {
		boolean isAccount = false;
		
		System.out.print("계좌번호: ");
		String accountNum = scanner.next();
		
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(accountDatas[i].getAccountNum())) {
				isAccount = true;
				
				System.out.print("비밀번호: ");
				String password = scanner.next();
				
				if (password.equals(accountDatas[i].getPassword())) {
					System.out.print("출금액: ");
					int money = scanner.nextInt();
					
					if (accountDatas[i].getMoney()-money < 0) {
						System.out.println("돈이 부족합니다.");
						return;
					}
					
					accountDatas[i].setMoney(accountDatas[i].getMoney()-money);
					System.out.println("출금완료");
				}
				else
					System.out.println("비밀번호가 틀렸습니다.");
			}
		}
		
		if (isAccount == false) {
			System.out.println("계좌번호가 존재하지 않습니다.");
		}
	}
	
	void sendMoney() {
		boolean isAccount = false;
		
		System.out.print("계좌번호: ");
		String accountNum = scanner.next();
		
		for (int i = 0; i < count; i++) {
			if (accountNum.equals(accountDatas[i].getAccountNum())) {
				System.out.print("비밀번호: ");
				String password = scanner.next();
				
				if (password.equals(accountDatas[i].getPassword())) {
					System.out.print("상대 계좌번호: ");
					String num = scanner.next();
					
					for (int j = 0; j < count; j++) {
						if (i != j || num.equals(accountDatas[j].getAccountNum())) {
							isAccount = true;
							System.out.print("송금액: ");
							int money = scanner.nextInt();
							
							if (accountDatas[i].getMoney()-money < 0) {
								System.out.println("돈이 부족합니다.");
								return;
							}
							
							accountDatas[i].setMoney(accountDatas[i].getMoney()-money);
							System.out.println("송금완료");
						}
					}
				}
				else {
					System.out.println("비밀번호가 틀렸습니다.");
					return;
				}
			}
		}
		
		if (isAccount == false) {
			System.out.println("계좌번호가 존재하지 않습니다.");
		}
	}
}
