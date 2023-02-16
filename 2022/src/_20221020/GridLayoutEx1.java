package _20221020;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayoutEx1 extends JFrame {
	GridLayoutEx1(String str) {
		super(str);
		
		setLayout(new GridLayout(3,2));
		
		for (int i = 0; i < 6; i++) {
			add(new JButton(i+"번 버튼"));
		}
		
		setSize(200,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutEx1("GridLayout 예제");
	}

}
