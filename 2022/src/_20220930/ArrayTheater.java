package _20220930;

import java.util.Scanner;

public class ArrayTheater {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] seat = new int[10];
		int totalSeat = seat.length;
		
		while (true) {
			System.out.println("---------------------");
			for (int i = 0; i < seat.length; i++) {
				System.out.printf(" %d", i+1);
			}
			System.out.println();
			
			System.out.println("---------------------");
			for (int i = 0; i < seat.length; i++) {
				System.out.printf(" %d", seat[i]);
			}
			System.out.println();
			
			System.out.printf("현재 좌석 수: %d\n", totalSeat);
			System.out.print("원하시는 좌석번호를 입력하세요(종료는 0): ");
			int seatNum = scanner.nextInt();
			
			if (seatNum > 10 || seatNum < 0) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			
			if (seatNum == 0) {
				System.out.println("종료합니다.");
				break;
			}
			
			if (seat[seatNum-1] == 0) {
				System.out.printf("%d번 좌석 예약되었습니다.\n", seatNum);
				seat[seatNum-1]++;
				totalSeat--;
			}
			else
				System.out.println("이미 예약된 자리입니다.");
		}
		
	}

}
