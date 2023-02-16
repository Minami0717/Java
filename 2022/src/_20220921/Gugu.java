package _20220921;

public class Gugu {

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%d x %d = %2d ", j, i, i*j);
			}
			System.out.println();
		}
	}

}
