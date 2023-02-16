package _20220928;

import java.util.Scanner;

public class Dictionary2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] kor = {"자바","파이썬","데이터베이스","사랑","집","책","자동차","야구"};
		String[] eng = {"Java","Python","DB","Love","House","Book","Car","Baseball"};
		
		System.out.println("한영 단어검색 프로그램입니다.");
		
		while (true) {
			String Word = null;
			
			System.out.println("1. 한글단어");
			System.out.println("2. 영문단어");
			System.out.println("3. 종료");
			
			System.out.print("메뉴 입력>> ");
			int choice = scanner.nextInt();
			
			switch (choice) {
			case 1:
				System.out.print("한글단어 입력하세요. ");
				String inputWord = scanner.next();
				
				for (int i = 0; i < kor.length; i++) {
					if (kor[i].equals(inputWord)) {
						Word = eng[i];
					}
				}
				
				if (Word == null)
					System.out.println("입력한 단어가 없습니다.");
				else
					System.out.println(Word);
				break;
				
			case 2:
				System.out.print("영문단어 입력하세요. ");
				inputWord = scanner.next();
				
				for (int i = 0; i < eng.length; i++) {
					if (eng[i].equalsIgnoreCase(inputWord)) {
						Word = kor[i];
					}
				}
				
				if (Word == null)
					System.out.println("입력한 단어가 없습니다.");
				else
					System.out.println(Word);
				break;
				
			case 3:
				System.out.println("프로그램 종료합니다.");
				System.exit(0);
			default:
				break;
			}
		}
	}
}
