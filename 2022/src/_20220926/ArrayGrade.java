package _20220926;

import java.util.Scanner;

public class ArrayGrade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("인원수 입력하세요. ");
		int n = scanner.nextInt();
		
		String[] name = new String[n];
		int[] kor = new int[n];
		int[] eng = new int[n];
		int[] math = new int[n];
		int[] total = new int[n];
		double[] avg = new double[n];
		int[] rank = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%d번째 사람 이름 = ", i+1);
			name[i] = scanner.next();
			System.out.printf("%d번째 사람 국어 = ", i+1);
			kor[i] = scanner.nextInt();
			System.out.printf("%d번째 사람 영어 = ", i+1);
			eng[i] = scanner.nextInt();
			System.out.printf("%d번째 사람 수학 = ", i+1);
			math[i] = scanner.nextInt();
			
			total[i] = kor[i] + eng[i] + math[i];
			avg[i] = total[i] / 3;
			rank[i] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (total[i] < total[j])
					rank[i]++;
			}
		}
		
		System.out.println("=====================성적처리 결과=====================");
		System.out.println("이 름\t국어\t영어\t수학\t합계\t평균\t석차");
		System.out.println("====================================================");
		for (int i = 0; i < n; i++) {
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%d\n", name[i], kor[i], eng[i], math[i], total[i], avg[i], rank[i]);
		}
		System.out.println("====================성적처리 결과 끝====================");
	}

}
