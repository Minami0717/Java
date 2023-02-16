package _20220930;

import java.util.Scanner;

public class ArrayLibrary {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[][] seat = new int[5][5];
		int totalSeat = 25;
		int seatCount = totalSeat;
		int col = 0, row = 0;
		
		loopOut:
		while (true) {
			do {
				System.out.print("앉고 싶은 행을 입력하세요. (1~5) : ");
				col = scanner.nextInt();
				if (col == 0) {
					System.out.println("종료합니다.");
					break loopOut;
				}
			} while (col > 5 || col < 1);
			
			do {
				System.out.print("앉고 싶은 열을 입력하세요. (1~5) : ");
				row = scanner.nextInt();
			} while (row > 5 || row < 1);
				
			if (seat[col-1][row-1] == 0) {
				System.out.printf("[%d행][%d열]에 배정되었습니다.\n\n", col, row);
				seat[col-1][row-1] = 1;
				seatCount--;
			}
			else
				System.out.printf("[%d행][%d열]은 이미 배정된 자리입니다.\n", col, row);
			
			for (int i = 0; i < seat.length; i++) {
				System.out.printf("\t%d열", i+1);
			}
			System.out.println();
			
			for (int i = 0; i < seat.length; i++) {
				System.out.printf("%d행\t", i+1);
				for (int j = 0; j < seat[i].length; j++) {
					if (seat[i][j] == 1)
						System.out.print("■\t");
					else
						System.out.print("□\t");
				}
				System.out.println();
			}
			
			System.out.printf("전체 좌석은 %d석이고 남은 좌석은 %d석입니다.\n", totalSeat, seatCount);
		}

	}

}
