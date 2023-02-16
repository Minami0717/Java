package _20220930;

public class ArrayEx3 {

	public static void main(String[] args) {
		int[][] arr = {
						{1,2},
						{3,4,5},
						{6,7,8,9}
					};
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println();
		}
	}

}
