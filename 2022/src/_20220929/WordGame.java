package _20220929;

import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("게임에 참가하는 인원은 몇명입니까>> ");
		int n = scanner.nextInt();
		
		String[] name = new String[n];
		
		for (int i = 0; i < n; i++) {
			System.out.print("참가자의 이름을 입력하세요>>");
			name[i] = scanner.next();
		}
		
		System.out.print("시작 단어 입력하세요>> ");
		String startWord = scanner.next();
		
		String lastWord = startWord;
		String newWord = "";
		boolean chk = true;
		
		System.out.printf("시작하는 단어는 %s 입니다\n", startWord);
		
		while (chk == true) {
			for (int i = 0; i < name.length; i++) {
				System.out.printf("%s>> ", name[i]);
				newWord = scanner.next();
				
				if (lastWord.charAt(lastWord.length()-1) != newWord.charAt(0)) {
					System.out.printf("%s이 졌습니다.", name[i]);
					chk = false;
					break;
				}
				lastWord = newWord;
			}
		}
		
	}

}
