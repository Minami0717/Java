package _20221014;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DrinkFunc {
	Scanner scanner = new Scanner(System.in);

	DrinkData[] drinks = new DrinkData[10];
	int count = 0;
	
	void menu() {
		System.out.println("\n메뉴 선택하세요...");
		System.out.println("1. 상품 등록");
		System.out.println("2. 상품 출력");
		System.out.println("3. 프로그램 종료");
		System.out.print("선택: ");
	}
	
	void input() {
		System.out.print("상품명: ");
		String name = scanner.next();
		
		System.out.print("단위: ");
		int ml = scanner.nextInt();
		
		System.out.print("수량: ");
		int num = scanner.nextInt();
		
		drinks[count++] = new DrinkData(name, ml, num, ml * num);
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	DecimalFormat df = new DecimalFormat("#,###");
	
	void print() {
		
		if (drinks[0] != null) {
			System.out.println("데이터 출력 시작합니다..");
			System.out.println("\n상품명\t단위\t수량\t금액");
			for (int i = 0; i < count; i++) {
				System.out.printf("%s\t%d\t%d\t%s\n", drinks[i].name, drinks[i].ml, drinks[i].num, df.format(drinks[i].price));
				DrinkData.total += drinks[i].price;
			}
			System.out.printf("\n*** 합계금액 %s 원\n", df.format(DrinkData.total));
		}
		else {
			System.out.println("데이터가 없습니다.");
			return;
		}
	}
}
