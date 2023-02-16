package _20220905;

import java.util.Scanner;

public class Login1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String id = "david";
		String password = "2525";
		String inID;
		String inPassword;
		
		System.out.print("ID 입력: ");
		inID = scanner.nextLine();
		System.out.print("Password 입력: ");
		inPassword = scanner.nextLine();
		
		if (id.equalsIgnoreCase(inID) && password.equals(inPassword))
			System.out.println("로그인 성공");
		else if (!id.equalsIgnoreCase(inID) && !password.equals(inPassword))
			System.out.println("No ID & No password");
		else if (!id.equalsIgnoreCase(inID))
			System.out.println("No ID");
		else if (!password.equals(inPassword))
			System.out.println("No password");
	}
}
