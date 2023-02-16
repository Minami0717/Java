package _20220928;

import java.util.Scanner;

public class DicApp {
	DicApp() {
		Scanner scanner = new Scanner(System.in);
		Dic dic = new Dic();
		
		String word;
		
		System.out.println("한영 단어검색 프로그램입니다.");
		
		while (true) {
			System.out.print("한영단어 입력하세요.(종료/quit) ");
			word = scanner.next();
			
			if (word.equalsIgnoreCase("quit") || word.equals("종료")) {
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
	
	public static void main(String[] args) {
		new DicApp();
	}
}
