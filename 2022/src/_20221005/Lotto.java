package _20221005;

import java.util.Random;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		
		int[] comLotto = new int[6];
		int[] inputLotto = new int[6];
		
		for (int i = 0; i < comLotto.length; i++) {
			for (int j = 0; j < comLotto.length; j++) {
				if (comLotto[i] == comLotto[j]) {
					continue;
				}
				else {
					comLotto[i] = random.nextInt(45)+1;
				}
			}
		}
		
		for (int i = 0; i < inputLotto.length; i++) {
			System.out.printf("로또번호 %d번째 입력>> ", i+1);
			inputLotto[i] = scanner.nextInt();
		}
		
		System.out.print("컴퓨터 로또번호 : ");
		for (int i = 0; i < comLotto.length; i++) {
			System.out.printf("%5d", comLotto[i]);
		}
		System.out.println();
		
		System.out.print("입력된 로또번호 : ");
		for (int i = 0; i < inputLotto.length; i++) {
			System.out.printf("%5d", inputLotto[i]);
		}
	}

}
