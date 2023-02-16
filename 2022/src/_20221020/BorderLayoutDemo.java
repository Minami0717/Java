package _20221020;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo extends JFrame {
	BorderLayoutDemo() {
		setSize(300,150);
		setTitle("BorderLayout");
		
		add(new JButton("동"), BorderLayout.EAST);
		add(new JButton("서"), BorderLayout.WEST);
		add(new JButton("남"), BorderLayout.SOUTH);
		add(new JButton("북"), BorderLayout.NORTH);
		add(new JButton("중앙"), BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutDemo();
	}

}
