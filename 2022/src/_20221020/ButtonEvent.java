package _20221020;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ButtonEvent extends JFrame {
	JButton button;
	
	ButtonEvent() {
		setLayout(new FlowLayout());
		
		button = new JButton("버튼을 누르시오");
		button.addActionListener(new MyListener());
		add(button);
		
		setTitle("이벤트 예제");
		setSize(300,300);
		setVisible(true);
	}
	
	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "버튼을 누르시오")
				button.setText("버튼누름");
			else
				button.setText("버튼을 누르시오");
		}
	}
	
	public static void main(String[] args) {
		new ButtonEvent();
	}

}
