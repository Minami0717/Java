package _20221024;

import javax.swing.JOptionPane;

public class JOPConfirm {
	
	public static void main(String[] args) {
		int i1 = JOptionPane.showConfirmDialog(null, "새로작성하신내용을저장하시겠습니까?", "저장", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		
		if (i1 == 0)
			System.out.println("YES");
		else if (i1 == 1)
			System.out.println("NO");
		else if (i1 == JOptionPane.CANCEL_OPTION)
			System.out.println("CANCEL");
		else if (i1 == JOptionPane.CLOSED_OPTION)
			System.out.println("CLOSED");
		
		System.out.println(i1);
		
		int i2 = JOptionPane.showConfirmDialog(null, "이름 입력을 계속 하시겠습니까?", "이름입력", JOptionPane.YES_NO_OPTION);
		
		if (i2 == 0)
			System.out.println("YES");
		else if (i2 == 1)
			System.out.println("NO");
	}

}
