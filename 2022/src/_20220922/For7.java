package _20220922;

public class For7 {

	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2*i-1; j++) {
				System.out.print(j+1);
			}
			System.out.println();
		}
	}

}
