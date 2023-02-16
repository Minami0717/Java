package _20221006;

public class Array3Ex1 {

	public static void main(String[] args) {
		int[][][] arr = {
							{{3,2,1,0},{6,5,4,3},{1,2,3,4}},
							{{10,11,12,13},{13,14,15,16},{16,17,18,19}},
							{{9,8,7,6},{6,5,4,3},{3,2,1,0}}
						};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					System.out.printf("%3d",arr[i][j][k]);
				}
				System.out.println();
			}
			System.out.println("=============");
		}
	}

}
