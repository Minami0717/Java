package _20220926;

public class ArrayBasket {

	public static void main(String[] args) {
		int[] gameScores = {12,5,21,15,32,10,6,31,11,10};
		int[] gameRebounds = {5,7,1,5,10,3,0,7,6,4};
		int[] gameAssists = {2,9,4,3,6,1,11,6,9,10};
		
		int max = gameScores[0];
		int game = 0;
		
		for (int i = 0; i < gameScores.length; i++) {
			if (max < gameScores[i]) {
				max = gameScores[i];
				game = i;
			}
		}
		
		System.out.println("선수의 최다득점 경기 기록:");
		System.out.printf("최다득점 경기는 game #%d\n", game+1);
		System.out.printf("득점은 %d점\n", gameScores[game]);
		System.out.printf("리바운드는 %d회\n", gameRebounds[game]);
		System.out.printf("어시스트는 %d회\n", gameAssists[game]);
	}

}
