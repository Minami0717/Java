package _20221007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardToString {

	public static void main(String[] args) throws IOException {
		InputStreamReader in = new InputStreamReader(System.in);
		
		BufferedReader input = new BufferedReader(in);
		
		System.out.print("문자열 입력하세요? ");
		
		String str = input.readLine();
		System.out.println(str);
	}

}
