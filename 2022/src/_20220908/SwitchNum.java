package _20220908;

import java.util.Scanner;

public class SwitchNum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("정수를 입력하세요");
		int number = scanner.nextInt();
		
		switch(number) {
		case 1: System.out.println("ONE"); break;
		case 2: System.out.println("TWO"); break;
		case 3: System.out.println("THREE"); break;
		case 4: System.out.println("FOUR"); break;
		case 5: System.out.println("FIVE"); break;
		case 6: System.out.println("SIX"); break;
		case 7: System.out.println("SEVEN"); break;
		case 8: System.out.println("EIGHT"); break;
		case 9: System.out.println("NINE"); break;
		default: System.out.println("OTHER");
		}
	}

}
