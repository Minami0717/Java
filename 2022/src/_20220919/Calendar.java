package _20220919;

import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("1. 연도를 입력하세요[종료는 0 입력] >> ");
		int year = scanner.nextInt();
		
		System.out.print("2. 월을 입력하세요(예 : 6) >> ");
		int month = scanner.nextInt();
		
		boolean leap = false;
		int sum = 0;
		int days = 0;
		
		for (int l = 1; l < year; l++) {
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
				sum += 366;
				leap = true;
			}
			else
				sum += 365;
		}
		
		switch (month-1) {
		
		case 11:
			sum += 30;
		case 10:
			sum += 31;
		case 9:
			sum += 30;
		case 8:
			sum += 31;
		case 7:
			sum += 31;
		case 6:
			sum += 30;
		case 5:
			sum += 31;
		case 4:
			sum += 30;
		case 3:
			sum += 31;
		case 2:
			if (leap)
				sum += 29;
			else
				sum += 28;
		case 1:
			sum += 31;
		}
		
		sum++;
		
		for (int i = month; i <= 12; i++) {
			switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				days = 31;
				break;
			case 4: case 6: case 9: case 11:
				days = 30;
				break;
			case 2:
				if (leap)
					days = 29;
				else
					days = 28;
				break;
			}
			
			int day = (sum % 7) ;
			
			System.out.printf("\n\n%25d년 %d월\n", year, month);
			System.out.println("---------------------------------------------------");
			System.out.println("SUN\tMON\tTUE\tWED\tTHU\tFRI\tSAT");
			System.out.println("---------------------------------------------------");
			
			for (int j = 0; j < day; j++) {
				System.out.print("\t");
			}
			
			for (int k = 1; k <= days; k++) {
				System.out.print(k+"\t");
				if ((day+k) % 7 == 0)
					System.out.print("\n");
			}
			month++;
			sum += days;
		}
	}
}
