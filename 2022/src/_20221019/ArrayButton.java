package _20221019;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArrayButton extends JFrame{
	JPanel panel = new JPanel();
	
	ArrayButton() {
		for (int i = 0; i < 10; i++) {
			JButton b = new JButton(i+"번 버튼");
			panel.add(b);
		}
		
		add(panel);
		
		setSize(230,230);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ArrayButton();
	}

}
