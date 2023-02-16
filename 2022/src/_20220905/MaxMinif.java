package _20220905;

import java.util.Scanner;

public class MaxMinif {

	public static void main(String[] args) {
		int first, second;
		int imsi = 0;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 정수: ");
		first = scanner.nextInt();
		
		System.out.print("두번째 정수: ");
		second = scanner.nextInt();
		
		if (first < second) {
			imsi = first;
			first = second;
			second = imsi;
		}
		
		System.out.printf("%d => %d", first, second);
	}

}
