package _20221019;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloSwingDemo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JButton button = new JButton("버튼");
		
		frame.setTitle("안녕, 스윙!");
		frame.setSize(300,100);
		frame.add(button);
		frame.setVisible(true);
	}

}
