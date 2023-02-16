package _20220905;

import java.util.Scanner;

public class SortNum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("첫번째 정수: ");
		int n1 = scanner.nextInt();
		
		System.out.print("두번째 정수: ");
		int n2 = scanner.nextInt();
		
		System.out.print("세번째 정수: ");
		int n3 = scanner.nextInt();
		
		int temp;
		
		if (n1 < n2) {
			temp = n1;
			n1 = n2;
			n2 = temp;
		}
		if (n1 < n3) {
			temp = n1;
			n1 = n3;
			n3 = temp;
		}
		if (n2 < n3) {
			temp = n2;
			n2 = n3;
			n3 = temp;
		}
		System.out.printf("%d>=%d>=%d", n1,n2,n3);
	}

}
