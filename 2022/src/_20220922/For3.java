package _20220922;

public class For3 {

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < 5-i; j++) {
				System.out.print(" ");
			}
			
			for (int j = 5-i; j <= 5; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (j >= 5 - i)
					System.out.print(j);
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
