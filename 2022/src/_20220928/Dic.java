package _20220928;

public class Dic {

	String[] kor = {"자바","파이썬","데이터베이스","사랑","집","책","자동차","야구"};
	String[] eng = {"Java","Python","DB","Love","House","Book","Car","Baseball"};
	String ChangeWord = null;
	
	void korTOeng(String word) {
		for (int i = 0; i < kor.length; i++) {
			if (kor[i].equals(word)) {
				ChangeWord = eng[i];
			}
		}
	}
	
	void engTOkor(String word) {
		for (int i = 0; i < eng.length; i++) {
			if (eng[i].equalsIgnoreCase(word)) {
				ChangeWord = kor[i];
			}
		}
	}
	
	public String dictionary(String word) {
		ChangeWord = null;
		char first = word.charAt(0);
		
		if (first > 122) {
			korTOeng(word);
		}
		else {
			engTOkor(word);
		}
		
		return ChangeWord;
	}
}
