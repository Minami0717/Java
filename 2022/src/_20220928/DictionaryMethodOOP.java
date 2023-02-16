package _20220928;

import java.util.Scanner;

public class DictionaryMethodOOP {
	String[] kor = {"자바","파이썬","데이터베이스","사랑","집","책","자동차","야구"};
	String[] eng = {"Java","Python","DB","Love","House","Book","Car","Baseball"};
	String ChangeWord = null;
	
	public String dictionary(String word) {
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
		DictionaryMethodOOP dic = new DictionaryMethodOOP();
		
		String word;
		
		System.out.println("한영 단어검색 프로그램입니다.");
		
		while (true) {
			System.out.print("한영단어 입력하세요.(종료:quit) ");
			word = scanner.next();
			
			if (word.equalsIgnoreCase("quit")) {
				System.out.println("프로그램 종료합니다.");
				break;
			}
			
			dic.ChangeWord = dic.dictionary(word);
			
			if (dic.ChangeWord == null)
				System.out.println("한영단어 검색 없는 단어입니다.");
			else
				System.out.println(dic.ChangeWord);
		}
	}

}
