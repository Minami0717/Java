package _20221020;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonColor extends JFrame {
	JButton yellow,pink,blue;
	JPanel panel;
	
	ButtonColor() {
		panel = new JPanel();
		yellow = new JButton("노란색");
		pink = new JButton("핑크색");
		blue = new JButton("파란색");
		
		yellow.addActionListener(new MyListener());
		pink.addActionListener(new MyListener());
		blue.addActionListener(new MyListener());
		
		panel.add(yellow);
		panel.add(pink);
		panel.add(blue);
		
		add(panel);
		
		setSize(300,200);
		setVisible(true);
	}
	
	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == yellow)
				panel.setBackground(Color.yellow);
			else if (e.getSource() == pink)
				panel.setBackground(Color.pink);
			else if (e.getSource() == blue)
				panel.setBackground(Color.blue);
		}
	}

	public static void main(String[] args) {
		new ButtonColor();
	}

}
