package _20221007;

import java.io.IOException;

public class Read {

	public static void main(String[] args) throws IOException {
		System.out.print("키보드 입력하세요? ");
		
		int code = System.in.read();

		System.out.println(code);
	}

}
