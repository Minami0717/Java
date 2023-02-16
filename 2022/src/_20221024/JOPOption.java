package _20221024;

import javax.swing.JOptionPane;

public class JOPOption {

	public static void main(String[] args) {
		String[] options = {"예","아니오","취소"};
		int ync = JOptionPane.showOptionDialog(null, "계속하려면 예를 누르세요.", "경고", JOptionPane.DEFAULT_OPTION,
				JOptionPane.WARNING_MESSAGE, null, options, options[0]);
		
		if (ync == 0)
			System.out.println("예");
		else if (ync == 1)
			System.out.println("아니오");
		else if (ync == 2)
			System.out.println("취소");
		
		System.out.println(ync);
	}

}
