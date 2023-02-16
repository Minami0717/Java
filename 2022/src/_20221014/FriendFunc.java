package _20221014;

import java.util.Scanner;

public class FriendFunc {
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
	
	void input() {
		System.out.print("이름: ");
		String name = scanner.next();
		
		System.out.print("전화번호: ");
		String phone = scanner.next();
		
		System.out.print("생년월일: ");
		int birth = scanner.nextInt();
		
		System.out.print("주소: ");
		String addr = scanner.next();
		
		friends[count++] = new FriendData(name, phone, birth, addr);
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
					friends[i] = friends[i+1];
					System.out.println("\n데이터 삭제가 완료되었습니다.");
					count--;
				}
				else
					break;
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
				System.out.println("데이터 검색이 완료되었습니다.");
				break;
			}
		}
		
		if (isData == false)
			System.out.println("해당하는 데이터가 존재하지 않습니다.");
	}

}
