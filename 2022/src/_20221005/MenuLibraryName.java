package _20221005;

import java.util.Scanner;

public class MenuLibraryName {

	static Scanner scanner = new Scanner(System.in);
	static String[][] seat = new String[5][5];
	static int totalSeat = 25;
	static int seatCount = 0;
	static int col = 0, row = 0;
	static String name = "";
	
	public static void reserveSeat() {
		
		do {
			System.out.print("앉고 싶은 행을 입력하세요. (1~5) : ");
			col = scanner.nextInt();
		} while (col > 5 || col < 1);

		do {
			System.out.print("앉고 싶은 열을 입력하세요. (1~5) : ");
			row = scanner.nextInt();
		} while (row > 5 || row < 1);
		
		System.out.print("예약자 이름을 입력하세요. ");
		String name = scanner.next();

		if (seat[col - 1][row - 1] == null) {
			System.out.printf("[%d행][%d열]에 배정되었습니다.\n\n", col, row);
			seat[col - 1][row - 1] = name;
			seatCount++;
		} else
			System.out.printf("[%d행][%d열]은 이미 배정된 자리입니다.\n", col, row);
	}

	public static void returnSeat() {
		
		do {
			System.out.print("반납하고 싶은 행을 입력하세요. (1~5) : ");
			col = scanner.nextInt();
		} while (col > 5 || col < 1);

		do {
			System.out.print("반납하고 싶은 열을 입력하세요. (1~5) : ");
			row = scanner.nextInt();
		} while (row > 5 || row < 1);

		if (seat[col - 1][row - 1] != null) {
			System.out.printf("[%d행][%d열]이 반납되었습니다.\n\n", col, row);
			seat[col - 1][row - 1] = null;
			seatCount--;
		} else
			System.out.printf("[%d행][%d열]은 빈 자리입니다.\n", col, row);
	}
	
	public static void printSeat() {
		
		
		for (int i = 0; i < seat.length; i++) {
			System.out.printf("\t%d열", i+1);
		}
		System.out.println();
		
		for (int i = 0; i < seat.length; i++) {
			System.out.printf("%d행\t", i+1);
			for (int j = 0; j < seat[i].length; j++) {
				if (seat[i][j] != null)
					System.out.printf("%s\t", seat[i][j]);
				else
					System.out.print("□\t");
			}
			System.out.println();
		}
		
		System.out.printf("전체 %d좌석중 %d좌석이 사용중이며 %d좌석이 비어있다.\n", totalSeat, seatCount, totalSeat-seatCount);
	}
	
	public static void main(String[] args) {
		
		int menu = 0;
		do {
			System.out.println("┌─────────────────────────────┐");
			System.out.println("│                             │");
			System.out.println("│          좌 석 배 정          │");
			System.out.println("│                             │");
			System.out.println("│          1. 좌석예약          │");
			System.out.println("│          2. 좌석반납          │");
			System.out.println("│          3. 좌석현황          │");
			System.out.println("│          4. 종료하기          │");
			System.out.println("│                             │");
			System.out.println("└─────────────────────────────┘");
			
			System.out.print("메뉴 선택하세요. ");
			menu = scanner.nextInt();
			
			switch (menu) {
			case 1:
				printSeat();
				reserveSeat();
				printSeat();
				break;
			case 2:
				printSeat();
				returnSeat();
				printSeat();
				break;
			case 3:
				printSeat();
				break;
			case 4:
				System.out.println("종료합니다.");
				break;
			default:
				break;
			}
		} while (menu != 4);
	}
}
