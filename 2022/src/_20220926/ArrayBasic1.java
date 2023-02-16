package _20220926;

import java.util.Scanner;

public class ArrayBasic1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] value = { 1, 4, 9, 3, 5 };
		int sum = 0;

		int[] num = new int[5];
		double[] value2 = new double[5];
		char[] chr = { 'K', 'O', 'R', 'E', 'A' };
		String[] name = new String[5];

		for (int i = 0; i < value.length; i++) {
			System.out.printf("value[%d] = %d\n", i, value[i]);
		}

		for (int i = 0; i < chr.length; i++) {
			System.out.printf("chr[%d] = %c\n", i, chr[i]);
		}

		for (int i = 0; i < value.length; i++) {
			System.out.print("점수 입력하세요? ");
			num[i] = scanner.nextInt();
			sum += num[i];
		}
		System.out.printf("sum = %d\n", sum);
	}

}
