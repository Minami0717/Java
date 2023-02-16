package _20220928;

import java.util.Scanner;

public class DictionaryMethod {
	static String[] kor = {"자바","파이썬","데이터베이스","사랑","집","책","자동차","야구"};
	static String[] eng = {"Java","Python","DB","Love","House","Book","Car","Baseball"};
	static String ChangeWord = null;
	
	public static String dic(String word) {
		ChangeWord = null;
		char first = word.charAt(0);
		if (first > 122) {
			for (int i = 0; i < kor.length; i++) {
				if (kor[i].equals(word)) {
					ChangeWord = eng[i];
				}
			}
		}
		else {
			for (int i = 0; i < eng.length; i++) {
				if (eng[i].equalsIgnoreCase(word)) {
					ChangeWord = kor[i];
				}
			}
		}
		
		return ChangeWord;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String word;
		
		System.out.println("한영 단어검색 프로그램입니다.");
		
		while (true) {
			System.out.print("한영단어 입력하세요.(종료:quit) ");
			word = scanner.next();
			
			if (word.equalsIgnoreCase("quit")) {
				System.out.println("프로그램 종료합니다.");
				break;
			}
			
			ChangeWord = dic(word);
			
			if (ChangeWord == null)
				System.out.println("한영단어 검색 없는 단어입니다.");
			else
				System.out.println(ChangeWord);
		}
	}

}
