package _20221020;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FlowWin extends JFrame{
	private JButton btn1,btn2,btn3,btn4,btn5;
	
	public FlowWin(String title) {
		setTitle(title);
		setSize(300,180);
		//setLayout(new FlowLayout());
		//setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		//setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		
		btn1 = new JButton("버튼 1");
		btn2 = new JButton("버튼 2");
		btn3 = new JButton("버튼 3");
		btn4 = new JButton("버튼 4");
		btn5 = new JButton("버튼 5");
		
		add(btn1); add(btn2);
		add(btn3); add(btn4);
		add(btn5);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowWin("FlowLayout 윈도");
	}

}
