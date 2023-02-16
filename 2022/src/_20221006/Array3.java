package _20221006;

public class Array3 {

	public static void main(String[] args) {
		int[][][] arr = new int[3][4][5];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.printf("[%d][%d][%d] ",i,j,k);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
