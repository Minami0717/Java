package _20221024;

import javax.swing.JOptionPane;

public class JOPInput {

	public static void main(String[] args) {
		String kor = JOptionPane.showInputDialog("국어 점수는?");
		System.out.println("국어 점수: " + kor);
		
		String name = JOptionPane.showInputDialog(null, "당신의 이름은?", "영진");
		if (name != null)
			System.out.println("이름: " + name);
		else
			System.out.println("취소 또는 닫기");
		
		String[] animal = {"사자","코끼리","기린","침팬지"};
		Object selectedAnimal = JOptionPane.showInputDialog(null, "동물을선택하세요?", "동물선택", JOptionPane.QUESTION_MESSAGE, null, animal, animal[2]);
		System.out.println(selectedAnimal);
		
		if (selectedAnimal == null)
			System.out.println("취소 또는 닫기");
		
		System.out.println(selectedAnimal);
	}

}
