package _20220905;

import java.util.Scanner;

public class Login {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int id = 12345;
		int inID;
		
		System.out.print("inID 입력해요. ");
		inID = scanner.nextInt();
		
		System.out.println("Hi");
		
		if (inID == id) {
			System.out.println("Master");
		} else {
			System.out.println("who are you?");
		}
	}

}
