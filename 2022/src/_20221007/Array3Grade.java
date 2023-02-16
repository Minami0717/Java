package _20221007;

import java.util.Scanner;

public class Array3Grade {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("인원수 입력하세요. ");
		int n = scanner.nextInt();
		
		String[] subjectName = {"국어", "영어", "수학"};
		String[][] name = new String[2][n];
		int[][][] subject = new int[2][n][subjectName.length+3];
		double[][] avg = new double[2][n];
		
		for (int i = 0; i < subject.length; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%d반 %d번째 사람 이름 입력하세요. ", i+1, j+1);
				name[i][j] = scanner.next();
				
				for (int k = 0; k < subjectName.length; k++) {
					System.out.printf("%s점수 = ", subjectName[k]);
					subject[i][j][k] = scanner.nextInt();
					subject[i][j][subjectName.length] += subject[i][j][k];
				}
				
				avg[i][j] = subject[i][j][subjectName.length] / (double)subjectName.length;
				
				subject[i][j][subjectName.length+1] = 1;
				subject[i][j][subjectName.length+2] = 1;
			}
		}
		
		//반 석차
		for (int k = 0; k < subject.length; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (subject[k][i][subjectName.length] < subject[k][j][subjectName.length])
						subject[k][i][subjectName.length+1]++;
				}
			}
		}
		
		//전교 석차
		for (int i = 0; i < subject.length; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < subject.length; k++) {
					for (int m = 0; m < n; m++) {
						if (subject[i][j][subjectName.length] < subject[k][m][subjectName.length])
							subject[i][j][subjectName.length+2]++;
					}
				}
			}
		}
		
		for (int k = 0; k < subject.length; k++) {
			System.out.printf("%d반\n", k+1);
			System.out.println("=========================================================================");
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t반석차\t전교석차");
			System.out.println("=========================================================================");
			
			for (int i = 0; i < n; i++) {
				System.out.printf("%d번", i+1);
				System.out.printf("\t%s", name[k][i]);
				
				for (int j = 0; j < subjectName.length+1; j++) {
					System.out.printf("\t%d점", subject[k][i][j]);
				}
				
				System.out.printf("\t%.2f점", avg[k][i]);
				
				for (int j = 0; j < 2; j++) {
					System.out.printf("\t%d등", subject[k][i][j+4]);
				}
				System.out.println("\n");
			}
		}
		
	}
	
}
