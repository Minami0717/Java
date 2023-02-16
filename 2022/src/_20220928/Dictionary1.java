package _20220928;

import java.util.Scanner;

public class Dictionary1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] kor = {"자바","파이썬","데이터베이스","사랑","집","책","자동차","야구"};
		String[] eng = {"Java","Python","DB","Love","House","Book","Car","Baseball"};
		
		System.out.println("한영 단어검색 프로그램입니다.");
		
		while (true) {
			String korWord = null;
			String engWord = null;
			System.out.print("한글/영어 단어 입력하세요. (종료:quit)");
			String word = scanner.nextLine();
			
			if (word.equalsIgnoreCase("quit")) {
				System.out.println("프로그램 종료합니다.");
				break;
			}
			
			for (int i = 0; i < kor.length; i++) {
				if (kor[i].equals(word)) {
					engWord = eng[i];
				}
			}
			
			for (int i = 0; i < eng.length; i++) {
				if (eng[i].equalsIgnoreCase(word)) {
					korWord = kor[i];
				}
			}
			
			if (engWord == null && korWord == null)
				System.out.println("한글/영어 단어 검색 없는 단어입니다.");
			else if (korWord != null)
				System.out.println(korWord);
			else
				System.out.println(engWord);
		}
	}

}
