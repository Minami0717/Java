package _20220930;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayFigure {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int[] score = new int[7];
		
		System.out.print("7명 심사위원의 점수 입력: ");
		for (int i = 0; i < score.length; i++) {
			score[i] = scanner.nextInt();
		}
		
		int max = score[0];
		int min = score[0];
		int maxIdx = 0;
		int minIdx = 0;
		int total = 0;
		
		for (int i = 0; i < score.length; i++) {
			if (max <= score[i]) {
				max = score[i];
				maxIdx = i;
			}
			if (min > score[i]) {
				min = score[i];
				minIdx = i;
			}
		}
		System.out.print("유효점수 :");
		for (int i = 0; i < score.length; i++) {
			if (i == maxIdx || i == minIdx)
				continue;
			System.out.printf(" %d", score[i]);
			total += score[i];
		}
		System.out.println();
		
		double avg = total / (score.length - 2.0);
		
		System.out.printf("합계: %d 평균: %.1f", total, avg);
	}

}
