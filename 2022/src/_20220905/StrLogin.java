package _20220905;

import java.util.Scanner;

public class StrLogin {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String id = "david";
		String inID;
		
		System.out.print("inID 입력해요. ");
		inID = scanner.nextLine();
		
		System.out.println("Hi");
		
		if (id.equals(inID)) {
			System.out.println("Master");
		} else {
			System.out.println("who are you?");
		}
	}

}
