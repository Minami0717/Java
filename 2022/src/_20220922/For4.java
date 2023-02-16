package _20220922;

public class For4 {

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			for (int j = i; j <= 5; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if (j >= i)
					System.out.print(j);
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
