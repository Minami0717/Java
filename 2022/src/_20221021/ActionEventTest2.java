package _20221021;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ActionEventTest2 extends JFrame implements ActionListener {

	JButton button;
	
	ActionEventTest2() {
		setLayout(new FlowLayout());
		
		button = new JButton("버튼을 누르시오");
		button.addActionListener(this);
		add(button);
		
		setTitle("이벤트 예제");
		setSize(300,300);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (button.getText() == "버튼을 누르시오")
			button.setText("버튼누름");
		else
			button.setText("버튼을 누르시오");
	}
	
	public static void main(String[] args) {
		new ActionEventTest2();
	}
}
