package _20221013;

import java.util.Scanner;

public class PhoneInfo {
	
	void menu() {
		System.out.println("메뉴 선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 프로그램 종료");
		System.out.print("선택: ");
	}
	
	void input() {
		Scanner scanner = new Scanner(System.in);
		
		PhoneBook[] pBooks = new PhoneBook[2];
		
		for (int i = 0; i < pBooks.length; i++) {
			
			System.out.print("이름: ");
			String name = scanner.next();
			
			System.out.print("전화번호: ");
			String phone = scanner.next();
			
			System.out.print("주소: ");
			String addr = scanner.next();
			
			pBooks[i] = new PhoneBook(name, phone, addr);
		}
		
		for (int i = 0; i < pBooks.length; i++) {
			pBooks[i].print();
		}
	}
}
