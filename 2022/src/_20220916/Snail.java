package _20220916;

public class Snail {

	public static void main(String[] args) {
		int height = 100, snail = 0, cnt = 0;
		
		while (true) {
			snail += 5;
			cnt++;
			
			if (snail > height) {
				System.out.printf("추카추카 달팽이는 %d 번 만에 우물 탈출했어요.", cnt);
				break;
			}
			
			if (snail >= 50)
				snail -= 2;
			else
				snail--;
			
			System.out.printf("[%d]달팽이가 이동한 높이 %d\n", cnt, snail);
		}
	}
}
