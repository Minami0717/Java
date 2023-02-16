package _20220926;

import java.util.Random;

public class ArrayMaxMin {

	public static void main(String[] args) {
		Random random = new Random();
		
		int[] n = new int[10];
		int max = 0;
		int min = 100;
		int maxIndex = 0;
		int minIndex = 0;
		
		for (int i = 0; i < n.length; i++) {
			n[i] = random.nextInt(100);
			System.out.print(n[i]+" ");
			if (max < n[i]) {
				max = n[i];
				maxIndex = i;
			}
			if (min > n[i]) {
				min = n[i];
				minIndex = i;
			}
		}
		
		System.out.printf("\n최대값: %d, 최대값인덱스: %d, 최소값: %d, 최소값인덱스: %d", max, maxIndex, min, minIndex);
	}

}
