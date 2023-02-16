package _20220908;

import java.util.Scanner;

public class SwitchSeason {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.print("달을 입력하세요(1~12)>> ");
			int month = scanner.nextInt();
			
			if (month == 0)
				break;
			
			String season = "";
			boolean error = false;
			
			switch (month) {
			case 3: case 4: case 5:
				season = "봄";
				break;
			case 6: case 7: case 8:
				season = "여름";
				break;
			case 9: case 10: case 11:
				season = "가을";
				break;
			case 12: case 1: case 2:
				season = "겨울";
				break;
			default:
				error = true;
				break;
			}
			if (error == true)
				System.out.println("잘못 입력");
			else
				System.out.printf("%s입니다\n", season);
		}
		
	}

}
