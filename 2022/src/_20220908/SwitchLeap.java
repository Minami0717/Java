package _20220908;

import java.util.Scanner;

public class SwitchLeap {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("년도를 입력하시오. ");
			int year = scanner.nextInt();
			if (year == 0)
				break;
			
			System.out.print("일수를 알고 싶은 월 입력하시오. ");
			int month = scanner.nextInt();
			
			int days = 0;
			boolean error = false;
			
			switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				days = 31;
				break;
			case 4: case 6: case 9: case 11:
				days = 30;
				break;
			case 2:
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
					days = 29;
				else
					days = 28;
				break;
			default:
				error = true;
				break;
			}
			
			if (error == true)
				System.err.println("잘못된 입력입니다.");
			else
				System.out.printf("%d년 %d월은 %d일\n", year, month, days);
		}
		
	}

}
