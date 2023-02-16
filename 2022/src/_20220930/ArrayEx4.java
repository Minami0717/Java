package _20220930;

import java.util.Scanner;

public class ArrayEx4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[][] arr = new int [2][2];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("입력: ");
				arr[i][j] = scanner.nextInt();
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.printf("%d\t", arr[i][j]);
			}
			System.out.println();
		}
	}

}
