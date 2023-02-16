package _20220915;

public class Gugudan {

	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 4; j++) {
				System.out.printf("%d X %d = %2d ", j, i, i*j);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int j = 4; j < 7; j++) {
				System.out.printf("%d X %d = %2d ", j, i, i*j);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int j = 7; j < 10; j++) {
				System.out.printf("%d X %d = %2d ", j, i, i*j);
			}
			System.out.println();
		}
	}

}
