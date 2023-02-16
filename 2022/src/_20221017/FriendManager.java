package _20221017;

import java.util.Scanner;

public class FriendManager {
	Scanner scanner = new Scanner(System.in);

	FriendData[] friends = new FriendData[10];
	int count = 0;
	boolean isData = false;
	
	void menu() {
		System.out.println("\n메뉴 선택하세요...");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 데이터 출력");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택: ");
	}
	
	void subMenu() {
		System.out.println("데이터 입력을 시작합니다..");
		System.out.println("1.일반 2.대학 3.회사");
		System.out.print("선택>> ");
		
		int n = scanner.nextInt();
		switch (n) {
		case 1:
			input();
			break;
		case 2:
			schoolInput();
			break;
		case 3:
			companyInput();
			break;
		default:
			break;
		}
	}
	
	void input() {
		System.out.print("이름: ");
		String name = scanner.next();
		
		System.out.print("전화번호: ");
		String phone = scanner.next();
		
		System.out.print("주소: ");
		String addr = scanner.next();
		
		friends[count++] = new FriendData(name, phone, addr);
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	void schoolInput() {
		System.out.print("이름: ");
		String name = scanner.next();
		
		System.out.print("전화번호: ");
		String phone = scanner.next();
		
		System.out.print("주소: ");
		String addr = scanner.next();
		
		System.out.print("전공: ");
		String major = scanner.next();
		
		System.out.print("학년: ");
		String year = scanner.next();
		
		friends[count++] = new SchoolData(name, phone, addr, major, year);
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	void companyInput() {
		System.out.print("이름: ");
		String name = scanner.next();
		
		System.out.print("전화번호: ");
		String phone = scanner.next();
		
		System.out.print("주소: ");
		String addr = scanner.next();
		
		System.out.print("회사: ");
		String company = scanner.next();
		
		friends[count++] = new CompanyData(name, phone, addr, company);
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	void print() {
		if (count == 0) {
			System.out.println("데이터가 없습니다.");
			return;
		}
		
		System.out.println("데이터 출력을 시작합니다..");
		for (int i = 0; i < count; i++) {
			friends[i].print();
		}
		System.out.println("데이터 출력이 완료되었습니다.");
	}
	
	void delete() {
		if (count == 0) {
			System.out.println("데이터가 없습니다.");
			return;
		}
		
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름: ");
		String name = scanner.next();
		isData = false;
		
		for (int i = 0; i < count; i++) {
			if (friends[i].name.equals(name)) {
				friends[i].print();
				isData = true;
				System.out.print("정말 삭제하시겠습니까?(y/n) ");
				String yn = scanner.next();
				
				if (yn.equalsIgnoreCase("y")) {
					for (int j = i; j < count; j++)
						friends[j] = friends[j+1];
					System.out.println("\n데이터 삭제가 완료되었습니다.");
					count--;
				}
				else {
					System.out.println("취소되었습니다.");
					break;
				}
			}
		}
		
		if (isData == false)
			System.out.println("해당하는 데이터가 존재하지 않습니다.");
	}
	
	void search() {
		if (count == 0) {
			System.out.println("데이터가 없습니다.");
			return;
		}
		
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름: ");
		String name = scanner.next();
		isData = false;
		
		for (int i = 0; i < count; i++) {
			if (friends[i].name.equals(name)) {
				friends[i].print();
				isData = true;
			}
		}
		
		if (isData == false)
			System.out.println("해당하는 데이터가 존재하지 않습니다.");
		else
			System.out.println("데이터 검색이 완료되었습니다.");
	}
}
