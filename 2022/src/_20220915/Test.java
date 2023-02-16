package _20220915;

public class Test {

	public static void main(String[] args) {
		for (int k = 0; k < 7; k+=3) {
			System.out.printf("    %d단	       %d단	  %d단\n", k+1,k+2,k+3);
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 4; j++) {
					System.out.printf("%d X %d = %2d ", k+j, i, (k+j)*i);
				}
				System.out.println();
			}
			System.out.println();
		}
		
	}

}
