package _20221007;

import java.util.Scanner;

public class Array2Grade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("인원수 입력하세요. ");
		int n = scanner.nextInt();
		
		String[] subjectName = {"국어", "영어", "수학"};
		String[] name = new String[n];
		int[][] subject = new int[n][subjectName.length+2];
		double[] avg = new double[n];
		
		for (int i = 0; i < n; i++) {
			System.out.printf("%d번째 사람 이름 입력하세요. ", i+1);
			name[i] = scanner.next();
			for (int j = 0; j < subjectName.length; j++) {
				System.out.printf("%s점수 = ", subjectName[j]);
				subject[i][j] = scanner.nextInt();
				subject[i][subjectName.length+1] += subject[i][j];
			}
			avg[i] = subject[i][subjectName.length+1] / subjectName.length;
			subject[i][subjectName.length] = 1;
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (subject[i][subjectName.length+1] < subject[j][subjectName.length+1])
					subject[i][subjectName.length]++;
			}
		}
		
		System.out.println("======================성적처리 결과======================");
		System.out.println("이름\t국어\t영어\t수학\t석차\t총점\t평균");
		System.out.println("======================================================");
		for (int i = 0; i < n; i++) {
			System.out.printf("%s", name[i]);
			for (int j = 0; j < subjectName.length+2; j++) {
				if (j == 3)
					System.out.printf("\t%d등", subject[i][j]);
				else
					System.out.printf("\t%d점", subject[i][j]);
			}
			System.out.printf("\t%.2f점\n", avg[i]);
		}
		System.out.println("=====================성적처리 결과 끝=====================");
	}



}
