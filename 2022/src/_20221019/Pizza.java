package _20221019;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pizza extends JFrame{
	
	public Pizza() {
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel.add(panel1);
		panel.add(panel2);
		
		JButton button = new JButton("자바 피자에 오신 것을 환영합니다. 피자의 종류를 선택하시오.");
		panel1.add(button);
		
		JButton button1 = new JButton("콤보 피자");
		JButton button2 = new JButton("포테이토 피자");
		JButton button3 = new JButton("불고기 피자");
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);
		
		add(panel);
		
		panel.setBackground(new Color(100,255,154));
		button.setBackground(Color.yellow);
		panel2.setBackground(Color.yellow);
		
		button.setForeground(new Color(100,56,154));
		button.setFont(new Font("한컴 바겐세일 B",Font.ITALIC,20));
		
		setSize(600,150);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Pizza();
	}

}
