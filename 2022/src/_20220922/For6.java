package _20220922;

public class For6 {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j <= 9-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
