package _20221020;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ButtonText extends JFrame {
	JButton button;
	JLabel label;
	
	ButtonText() {
		button = new JButton("ActionEvent 버튼");
		label = new JLabel("아직 버튼이 눌러지지 않았습니다.");
		
		button.addActionListener(new MyListener());
		
		setLayout(new FlowLayout());
		add(button);
		add(label);
		
		setSize(250,200);
		setVisible(true);
	}
	
	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "ActionEvent 버튼") {
				button.setText("액션이벤트 버튼");
				label.setText("버튼이 눌러졌습니다.");
			}
			else {
				button.setText("ActionEvent 버튼");
				label.setText("아직 버튼이 눌러지지 않았습니다.");
			}
		}
	}
	public static void main(String[] args) {
		new ButtonText();
	}

}
