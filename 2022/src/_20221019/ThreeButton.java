package _20221019;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ThreeButton extends JFrame{
	JPanel panel = new JPanel();
	JButton button1 = new JButton("버튼1");
	JButton button2 = new JButton("버튼2");
	JButton button3 = new JButton("버튼3");
	
	ThreeButton() {
		setTitle("안녕, 스윙!");
		setSize(300,200);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		add(panel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ThreeButton();
	}
}
