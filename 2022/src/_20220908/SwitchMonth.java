package _20220908;

import java.util.Scanner;

public class SwitchMonth {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("일수를 알고 싶은 월 입력하시오. ");
		int month = scanner.nextInt();
		int days = 0;
		
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			days = 31;
			break;
		case 4: case 6: case 9: case 11:
			days = 30;
			break;
		case 2:
			days = 28;
			break;
		default:
			break;
		}
		
		System.out.printf("%d월은 %d일", month, days);
	}

}
