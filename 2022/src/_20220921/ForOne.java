package _20220921;

public class ForOne {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == j)
					System.out.print(1);
				else
					System.out.print(0);
			}
			System.out.println();
		}
	}

}
